package br.com.tresptecnologia.core.jpa.mapper.impl.model;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Classe responsavel
 */
@Getter
@Setter
public class ObjectIdentifier {
    //Cache da Estrutura
    String prefix;
    String field;
    boolean isArray;
    List<String> properties;

    // Cache do mapeamento
    Object valueId;
    ObjectNode myObject;

    // Dados do pai
    ObjectIdentifier parentId;
    String prefixParent;

    public String getFieldClean() {
        return normalize(getField().substring(getField().lastIndexOf(".")))
                .replace(".", "");
    }

    public String getProperty(String property) {
        if (prefix == null) {
            return property;
        }
        return prefix + "." + property;
    }

    public String getPrefixClean() {
        if (parentId == null) {
            return normalize(prefix);
        }
        return normalize(prefix.replace(parentId.getPrefix() + ".", ""));
    }

    public String normalize(String value) {
        return value.replace("*", "")
                .replace("[]", "");
    }

    public void clear() {
        this.myObject = null;
        this.valueId = null;
    }
}
