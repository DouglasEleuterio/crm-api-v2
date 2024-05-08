package br.com.tresptecnologia.core.repository;

import br.com.tresptecnologia.core.repository.specification.SelectionConstructor;
import br.com.tresptecnologia.shared.util.StringUtil;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.jpa.mapper.Row;
import br.com.tresptecnologia.core.jpa.rsql.RsqlSpecificationModel;
import br.com.tresptecnologia.core.jpa.util.JpaExpressionUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<T> {
    Page<T> findAll(RsqlSpecificationModel spec, Pageable pageable);

    List<T> findAll(RsqlSpecificationModel spec, Sort sort);

    <Y> Page<Y> findAll(@NonNull SelectionConstructor<Y, T> selectionConstructor,
                        @Nullable Specification<T> spec,
                        @NonNull Pageable pageable);

    <Y> List<Y> findAll(@NonNull SelectionConstructor<Y, T> selectionConstructor,
                        @Nullable Specification<T> spec,
                        @Nullable Sort sort);


    List<Row> fetch(final List<String> columns, final Specification<T> spec);

    List<Row> fetch(final List<String> columns, final Specification<T> spec, Sort sort);

    List<Row> fetch(final List<String> columns, final Specification<T> spec, Integer page, Integer size);

    List<Row> fetch(final List<String> columns, final Specification<T> spec, Integer page, Integer size, Sort sort);

    Page<Row> fetch(final List<String> columns, final Specification<T> spec, Pageable pageable);

    default <R> boolean existsBy(@Nullable Long id, String property, R value) {
        return count(((root, query, builder) -> {
            Predicate propertyPredicate = builder.equal(root.get(property), value);

            if (id != null) {
                return builder.and(propertyPredicate, builder.notEqual(root.get("id"), id));
            }

            return propertyPredicate;
        })) > 0;
    }

    default <R> boolean existsByIgnoringCaseAndAccents(@Nullable Long id, String property, R value) {
        return count(((root, query, builder) -> {
            Predicate propertyPredicate = builder.equal(JpaExpressionUtils
                            .expIgnoreAccents(builder, root.get(property)),
                    StringUtil.ignoreAccents(value.toString()
                            .replace('*', '%')).toUpperCase());

            if (id != null) {
                return builder.and(propertyPredicate, builder.notEqual(root.get("id"), id));
            }

            return propertyPredicate;
        })) > 0;
    }

    default Optional<T> getExistsBy(@NonNull Long id) {
        if (existsBy(null, "id", id)) {
            return findById(id);
        }
        return Optional.empty();
    }
}
