package br.com.tresptecnologia.core.repository;

import br.com.tresptecnologia.core.repository.specification.SelectionConstructor;
import br.com.tresptecnologia.core.jpa.Property;
import br.com.tresptecnologia.core.jpa.mapper.Row;
import br.com.tresptecnologia.core.jpa.mapper.row.TupleRecord;
import br.com.tresptecnologia.core.jpa.metadata.DefaultEntityMetadata;
import br.com.tresptecnologia.core.jpa.metadata.IEntityMetadata;
import br.com.tresptecnologia.core.jpa.rsql.RsqlSpecificationModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional(
        readOnly = true
)
public class RsqlRepository<T, D> extends SimpleJpaRepository<T, D> {

    private final EntityManager entityManager;
    private final IEntityMetadata entityMetadata;
    private final JpaEntityInformation<T, ?> entityInformation;

    public RsqlRepository(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityMetadata = new DefaultEntityMetadata(entityManager.getEntityManagerFactory());
        this.entityInformation = entityInformation;
    }

    public RsqlRepository(final Class<T> domainClass, final EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.entityMetadata = new DefaultEntityMetadata(entityManager.getEntityManagerFactory());
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
    }

    public Page<T> findAll(final RsqlSpecificationModel spec, final Pageable pageable) {
        final TypedQuery<T> query = this.getQuery(spec.toSpecificationWithFetchProperties(), pageable);
        return (pageable.isUnpaged() ? new PageImpl<>(query.getResultList())
                : this.readPageInternal(query, this.getDomainClass(), pageable, spec.toSpecification()));
    }

    public List<T> findAll(final RsqlSpecificationModel spec, final Sort sort) {
        return super.findAll(spec.toSpecificationWithFetchProperties(), sort);
    }

    public <Y> Page<Y> findAll(@NonNull final SelectionConstructor<Y, T> selectionConstructor,
                               @Nullable final Specification<T> spec,
                               @NonNull final Pageable pageable) {


        final TypedQuery<Y> query = this.getQueryConstructor(
                selectionConstructor,
                spec,
                pageable.getSort());

        return (pageable.isUnpaged() ? new PageImpl<>(query.getResultList())
                : this.readPageInternal(query, this.getDomainClass(), pageable,
                spec));
    }

    public <Y> List<Y> findAll(@NonNull SelectionConstructor<Y, T> selectionConstructor,
                               @Nullable Specification<T> spec,
                               @Nullable Sort sort) {

        return this.getQueryConstructor(
                selectionConstructor,
                spec,
                sort).getResultList();
    }

    private <Y> TypedQuery<Y> getQueryConstructor(@NonNull SelectionConstructor<Y, T> selectionConstructor,
                                                  @Nullable Specification<T> spec,
                                                  @Nullable Sort sort) {

        Objects.requireNonNull(selectionConstructor, "As definições de seleção não podem ser nulas");
        Objects.requireNonNull(selectionConstructor.modelClass(), "A classe de mapeamento não pode ser nula");
        Objects.requireNonNull(selectionConstructor.specificationSelection(), "A lista de colunas para selecionar não pode ser nula");

        final CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        final Class<T> domainClass = getDomainClass();

        final CriteriaQuery<Y> query = builder.createQuery(selectionConstructor.modelClass());

        final Root<T> root = query.from(domainClass);

        if (spec != null) {
            final Predicate predicate = spec.toPredicate(root, query, builder);
            if (predicate != null) {
                query.where(predicate);
            }
        }

        List<Selection<T>> selectionList = selectionConstructor.specificationSelection().get(root);

        query.select(builder.construct(selectionConstructor.modelClass(),
                selectionList.toArray(Selection[]::new)));

        if (sort != null && sort.isSorted()) {
            query.orderBy(QueryUtils.toOrders(sort, root, builder));
        }

        return entityManager.createQuery(query);
    }

    protected <S> Page<S> readPageInternal(final TypedQuery<S> query,
                                           final Class<T> domainClass,
                                           final Pageable pageable,
                                           final @Nullable Specification<T> specCount) {

        if (pageable.isPaged()) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        return PageableExecutionUtils.getPage(query.getResultList(), pageable,
                () -> executeCountQuery(this.getCountQuery(specCount, domainClass)));
    }

    private static long executeCountQuery(TypedQuery<Long> query) {
        Assert.notNull(query, "TypedQuery must not be null");
        List<Long> totals = query.getResultList();
        long total = 0L;
        for (Long element : totals) {
            total += element == null ? 0 : element;
        }
        return total;
    }

    public List<Row> fetch(final List<String> columns, final Specification<T> spec) {
        return fetch(columns, spec, null, null, null);
    }

    public List<Row> fetch(final List<String> columns, final Specification<T> spec, Sort sort) {
        return fetch(columns, spec, null, null, sort);
    }

    public List<Row> fetch(final List<String> columns, final Specification<T> spec, Integer page, Integer size) {
        return fetch(columns, spec, page, size, null);
    }

    public List<Row> fetch(@NonNull final List<String> columns,
                           @NonNull final Specification<T> spec,
                           @Nullable Integer page,
                           @Nullable Integer size,
                           @Nullable Sort sort) {

        PaginatedQuery query = buildCriteriaQueryInternal(columns, spec, sort, page, size);

        final TypedQuery<Tuple> typedQuery = entityManager.createQuery(query.getQuery());

        if (!query.isSubqueryPaginated()) {
            if (page != null) {
                typedQuery.setFirstResult(getFirstResult(page, size));
            }

            if (size != null) {
                typedQuery.setMaxResults(size);
            }
        }

        return typedQuery.getResultList().stream().map(TupleRecord::of)
                .toList();
    }

    public Page<Row> fetch(
            final List<String> columns,
            final Specification<T> spec,
            final @NonNull Pageable pageable) {

        PaginatedQuery query = buildCriteriaQueryInternal(columns, spec,
                pageable.getSort(),
                pageable.getPageNumber(),
                pageable.getPageSize());

        final TypedQuery<Tuple> typedQuery = entityManager.createQuery(query.getQuery());

        if (pageable.isUnpaged()) {
            return new PageImpl<>(typedQuery.getResultList()).map(TupleRecord::of);
        }

        if (!query.isSubqueryPaginated()) {
            return this.readPageInternal(typedQuery, this.getDomainClass(), pageable, spec)
                    .map(TupleRecord::of);
        }


        return PageableExecutionUtils.getPage(typedQuery.getResultList(), pageable,
                        () -> executeCountQuery(this.getCountQuery(spec, this.getDomainClass())))
                .map(TupleRecord::of);

    }

    private PaginatedQuery buildCriteriaQueryInternal(final List<String> columns,
                                                      final Specification<T> spec,
                                                      final Sort sort,
                                                      Integer page,
                                                      Integer size) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createTupleQuery();

        boolean hasColumnCollection = false;

        Root<T> root = query.from(getDomainClass());

        var selections = new ArrayList<Selection<?>>();

        for (String column : columns) {
            String field = column.replace("*", "")
                    .replace("[]", "");
            var fieldProperty = new Property(field, entityMetadata);
            var rootPath = fieldProperty.getPath(root);
            final String alias = fieldProperty.getAlias();
            if (!hasColumnCollection) {
                hasColumnCollection = alias.contains("[]");
            }
            selections.add(rootPath.alias(alias));
        }

        query.multiselect(selections);

        boolean isSubQueryPaginated = hasColumnCollection && (page != null || size != null) && entityInformation.getIdAttribute() != null;

        if (isSubQueryPaginated) {
            final SingularAttribute<? super T, ?> attributeId = entityInformation.getIdAttribute();
            List<?> ids = fetchIdPageable(spec, sort, page, size, attributeId.getName(), attributeId.getType().getJavaType());
            if (ids != null && !ids.isEmpty()) {
                query.where(root.get(entityInformation.getIdAttribute().getName())
                        .in(ids));
            }
        } else if (spec != null) {
            final Predicate predicate = spec.toPredicate(root, query, builder);
            if (predicate != null) {
                query.where(predicate);
            }
        }

        if (sort != null) {
            query.orderBy(QueryUtils.toOrders(sort, root, builder));
        }

        return new PaginatedQuery(query, isSubQueryPaginated);
    }

    private <U> List<U> fetchIdPageable(final Specification<T> spec,
                                        final Sort sort,
                                        final Integer page,
                                        final Integer size,
                                        final String attributeId,
                                        final Class<U> clazzId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<U> query = builder.createQuery(clazzId);

        Root<T> root = query.from(getDomainClass());
        query.select(root.get(attributeId));

        if (spec != null) {
            final Predicate predicate = spec.toPredicate(root, query, builder);
            if (predicate != null) {
                query.where(predicate);
            }
        }

        if (sort != null) {
            query.orderBy(QueryUtils.toOrders(sort, root, builder));
        }

        final TypedQuery<U> typedQuery = entityManager.createQuery(query);

        if (page != null) {
            typedQuery.setFirstResult(getFirstResult(page, size));
        }

        if (size != null) {
            typedQuery.setMaxResults(size);
        }

        return typedQuery.getResultList();

    }

    private int getFirstResult(Integer page, Integer size) {
        return size == null ? page : (page * size);
    }

}
