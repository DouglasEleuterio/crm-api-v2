package br.com.tresptecnologia.core.jpa.rsql;

import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.OrNode;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.springframework.data.jpa.domain.Specification;

public class RsqlSpecificationVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

    private final RsqlSpecificationBuilder<T> builder;

    public RsqlSpecificationVisitor() {
        builder = new RsqlSpecificationBuilder<>();
    }

    public RsqlSpecificationVisitor(final String ...fetchProperties) {
        builder = new RsqlSpecificationBuilder<>(fetchProperties);
    }

    @Override
    public Specification<T> visit(AndNode node, Void param) {
        return builder.createSpecification(node);
    }

    @Override
    public Specification<T> visit(OrNode node, Void param) {
        return builder.createSpecification(node);
    }

    @Override
    public Specification<T> visit(ComparisonNode node, Void params) {
        return builder.createSpecification(node);
    }
}
