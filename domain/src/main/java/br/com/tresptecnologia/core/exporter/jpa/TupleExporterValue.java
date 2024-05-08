package br.com.tresptecnologia.core.exporter.jpa;

import br.com.tresptecnologia.core.exporter.IExporterValue;

import jakarta.persistence.Tuple;

public class TupleExporterValue implements IExporterValue {
    private final Tuple tuple;

    public TupleExporterValue(Tuple tuple) {
        this.tuple = tuple;
    }

    @Override
    public Object get(String columnField) {
        return tuple.get(columnField);
    }
}
