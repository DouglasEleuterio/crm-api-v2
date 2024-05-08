package br.com.tresptecnologia.core.jpa.mapper.impl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa o objeto identificador root. Tem como objetivo ter a referencia ao
 * ObjectIdentifier que representa o ID do objeto principal e a lista de identificadores de
 * objetos que estão em sua hierarquia.
 */
@Getter
@Setter
public class ObjectRoot {
    ObjectIdentifier rootObjectId;
    List<ObjectIdentifier> objectIdentifiers;

    public ObjectRoot() {
        this.objectIdentifiers = new ArrayList<>();
    }

    /**
     * Usado para realizar a limpeza de dados que estão sendo cacheados
     */
    public void clear() {
        if (Objects.nonNull(objectIdentifiers)) {
            objectIdentifiers.forEach(ObjectIdentifier::clear);
        }
    }
}