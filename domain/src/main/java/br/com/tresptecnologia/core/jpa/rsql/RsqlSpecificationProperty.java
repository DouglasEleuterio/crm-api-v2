package br.com.tresptecnologia.core.jpa.rsql;

import br.com.tresptecnologia.core.jpa.Property;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RsqlSpecificationProperty {
    private Property property;
    private ComparisonOperator operator;
    private List<String> arguments;

    public RsqlSpecificationProperty(String property, ComparisonOperator operator, List<String> arguments, String[] properties) {
        this.property = new Property(property, properties);
        this.operator = operator;
        this.arguments = arguments;
    }
}
