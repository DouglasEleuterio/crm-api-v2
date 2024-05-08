package br.com.tresptecnologia.core.jpa.util;

import br.com.tresptecnologia.core.jpa.rsql.RsqlSpecificationVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpecificationUtils {

    public static <T> Specification<T> rsqlToSpecification(final String search) {
        if (StringUtils.isNotBlank(search)) {
            Node rootNode = new RSQLParser().parse(search);
            return rootNode.accept(new RsqlSpecificationVisitor<>());
        }
        return null;
    }

    public static <T> Specification<T> rsqlToSpecificationWithFetchProperties(final String search, final String... fetchProperties) {
        if (StringUtils.isNotBlank(search)) {
            Node rootNode = new RSQLParser().parse(search);
            return rootNode.accept(new RsqlSpecificationVisitor<>(fetchProperties));
        }
        return null;
    }
}
