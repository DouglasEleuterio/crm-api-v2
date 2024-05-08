package br.com.tresptecnologia.core.exporter.builder;

import br.com.tresptecnologia.core.exporter.ExporterColumn;

import java.util.List;

public interface IFluentColumnBuilder {
    IFluentColumnBuilder add(String field, String label);

    IFluentColumnBuilder parse(List<String> values, String separator);

    List<ExporterColumn> build();
}
