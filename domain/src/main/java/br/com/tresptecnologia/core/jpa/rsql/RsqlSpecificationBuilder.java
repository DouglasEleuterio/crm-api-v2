package br.com.tresptecnologia.core.jpa.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.LogicalNode;
import cz.jirutka.rsql.parser.ast.LogicalOperator;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.jpa.domain.Specification.where;

public class RsqlSpecificationBuilder<T> {

    private final String[] properties;

    public RsqlSpecificationBuilder(final String... fetchProperties) {
        this.properties = fetchProperties;
    }

    public Specification<T> createSpecification(final Node node) {
        if (node instanceof LogicalNode logicalNode) {
            return createSpecification(logicalNode);
        }
        if (node instanceof ComparisonNode comparisonNode) {
            return createSpecification(comparisonNode);
        }
        return null;
    }

    public Specification<T> createSpecification(final LogicalNode logicalNode) {
        List<Specification<T>> specs = logicalNode.getChildren().stream().map(this::createSpecification)
                .filter(Objects::nonNull).toList();

        Specification<T> result = specs.get(0);
        if (logicalNode.getOperator() == LogicalOperator.AND) {
            for (int i = 1; i < specs.size(); i++) {
                result = where(result).and(specs.get(i));
            }
        } else if (logicalNode.getOperator() == LogicalOperator.OR) {
            for (int i = 1; i < specs.size(); i++) {
                result = where(result).or(specs.get(i));
            }
        }

        return result;
    }

    public Specification<T> createSpecification(ComparisonNode comparisonNode) {
        final RsqlSpecificationProperty specificationProperty = new RsqlSpecificationProperty(comparisonNode.getSelector(),
                comparisonNode.getOperator(), comparisonNode.getArguments(), properties);

        return where(new RsqlSpecification<>(specificationProperty));
    }

}
