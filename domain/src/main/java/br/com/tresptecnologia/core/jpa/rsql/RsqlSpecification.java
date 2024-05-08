package br.com.tresptecnologia.core.jpa.rsql;

import br.com.tresptecnologia.core.jpa.util.JpaArgumentConverter;
import br.com.tresptecnologia.shared.util.StringUtil;
import br.com.tresptecnologia.core.jpa.util.JpaExpressionUtils;
import br.com.tresptecnologia.core.jpa.util.JpaPathUtils;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;

public class RsqlSpecification<T> implements Specification<T> {

    private final transient RsqlSpecificationProperty specificationProperty;

    public RsqlSpecification(RsqlSpecificationProperty specificationProperty) {
        this.specificationProperty = specificationProperty;
    }

    @Override
    public Predicate toPredicate(@NonNull final Root<T> root,
                                 @Nullable final CriteriaQuery<?> query,
                                 @NonNull final CriteriaBuilder builder) {

        final Path<?> path = specificationProperty.getProperty().getPath(root);
        final ComparisonOperator operator = specificationProperty.getOperator();
        final List<String> arguments = specificationProperty.getArguments();

        return toPredicate(arguments, operator, path, builder);
    }

    private Predicate toPredicate(
            final List<String> arguments,
            final ComparisonOperator operator,
            final Path<?> path,
            final CriteriaBuilder builder) {

        final List<Object> args = JpaPathUtils.castArguments(path, arguments);
        final Object argument = JpaArgumentConverter.convert(path, arguments);

        return switch (Objects.requireNonNull(RsqlSearchOperation.getSimpleOperator(operator))) {
            case EQUAL -> getEqualPredicate(argument, path, builder);
            case NOT_EQUAL -> getNotEqualPredicate(argument, path, builder);
            case GREATER_THAN ->
                    builder.greaterThan((Expression) path, (Expression) JpaExpressionUtils.getExpression(argument, builder, path));
            case GREATER_THAN_OR_EQUAL ->
                    builder.greaterThanOrEqualTo((Expression) path, (Expression) JpaExpressionUtils.getExpression(argument, builder, path));
            case LESS_THAN ->
                    builder.lessThan((Expression) path, (Expression) JpaExpressionUtils.getExpression(argument, builder, path));
            case LESS_THAN_OR_EQUAL ->
                    builder.lessThanOrEqualTo((Expression) path, (Expression) JpaExpressionUtils.getExpression(argument, builder, path));
            case IN -> path.in(args);
            case NOT_IN -> builder.not(path.in(args));
        };
    }

    private Predicate getEqualPredicate(final Object argument, final Path<?> path,
                                        final CriteriaBuilder builder) {
        if (JpaPathUtils.isLike(argument)) {
            if (!String.class.isAssignableFrom(path.getJavaType())) {
                return builder.like(path.as(String.class), getArgumentLike(argument));
            }
            return builder.like(JpaExpressionUtils.expIgnoreAccents(builder, path), getArgumentLike(argument));
        } else if (argument == null) {
            return builder.isNull(path);
        } else {
            return builder.equal(path, argument);
        }
    }

    private Predicate getNotEqualPredicate(final Object argument, final Path<?> path,
                                           final CriteriaBuilder builder) {
        if (JpaPathUtils.isLike(argument)) {
            return builder.notLike(JpaExpressionUtils.expIgnoreAccents(builder, path), getArgumentLike(argument));
        } else if (argument == null) {
            return builder.isNotNull(path);
        } else {
            return builder.notEqual(path, argument);
        }
    }

    private String getArgumentLike(final Object argument) {
        return StringUtil.ignoreAccents(argument.toString()
                .replace('*', '%')).toUpperCase();
    }


}
