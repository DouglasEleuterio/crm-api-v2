package br.com.tresptecnologia.core.jpa.mapper.row;


import br.com.tresptecnologia.core.jpa.mapper.Row;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;

import java.util.Collection;

/**
 * Utiliza o Tuple do JPA para armazenar os chaves e valores
 */
public class TupleRecord implements Row {

    final Tuple tuple;

    public TupleRecord(Tuple tuple) {
        this.tuple = tuple;
    }

    public static Row of(Tuple value) {
        return new TupleRecord(value);
    }

    @Override
    public boolean has(String key) {
        return tuple.get(key) != null;
    }

    @Override
    public Object get(String key) {
        return tuple.get(key);
    }

    @Override
    public Collection<String> getKeys() {
        return tuple.getElements().stream().map(TupleElement::getAlias).toList();
    }
}
