package br.com.tresptecnologia.core.jpa.mapper.row;


import br.com.tresptecnologia.core.jpa.mapper.Row;

import java.util.Collection;
import java.util.Map;

/**
 * Utiliza um map para armazenar os dados de chave e valores
 */
public class MapRecord implements Row {

    final Map<String, Object> value;

    public MapRecord(Map<String, Object> value) {
        this.value = value;
    }

    public static Row of(Map<String, Object> value) {
        return new MapRecord(value);
    }

    @Override
    public boolean has(String key) {
        return value.containsKey(key);
    }

    @Override
    public Object get(String key) {
        return value.get(key);
    }

    @Override
    public Collection<String> getKeys() {
        return value.keySet();
    }
}
