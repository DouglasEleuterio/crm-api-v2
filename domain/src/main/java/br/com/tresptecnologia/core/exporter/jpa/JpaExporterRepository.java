package br.com.tresptecnologia.core.exporter.jpa;

import br.com.tresptecnologia.core.exporter.IExporterValue;
import br.com.tresptecnologia.core.jpa.Property;
import br.com.tresptecnologia.core.exporter.ExporterColumn;
import br.com.tresptecnologia.core.exporter.IExporterPagination;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JpaExporterRepository implements IExporterPagination {

    private final EntityManager entityManager;

    public JpaExporterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> List<IExporterValue> fetch(final Specification<T> spec, List<ExporterColumn> columns,
                                          int first, int size, Sort sort, Class<T> clazz) {
        var builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = builder.createTupleQuery();
        Root<T> root = cq.from(clazz);

        if (spec != null) {
            applySpecificationToCriteria(builder, spec, root, cq);
        }

        if (sort != null) {
            cq.orderBy(QueryUtils.toOrders(sort, root, builder));
        }

        var selections = new ArrayList<Selection<?>>();

        for (ExporterColumn column : columns) {
            var fieldProperty = new Property(column.getField());
            selections.add(fieldProperty.getPath(root).alias(column.getField()));
        }
        cq.multiselect(selections);

        return entityManager.createQuery(cq)
                .setFirstResult(first)
                .setMaxResults(size)
                .getResultList().stream()
                .map(tuple -> (IExporterValue) new TupleExporterValue(tuple))
                .toList();
    }

    private <T> void applySpecificationToCriteria(CriteriaBuilder builder,
                                                  Specification<T> spec,
                                                  Root<T> root,
                                                  CriteriaQuery<Tuple> query) {
        Predicate predicate = spec.toPredicate(root, query, builder);
        if (predicate != null) {
            query.where(predicate);
        }
    }
}
