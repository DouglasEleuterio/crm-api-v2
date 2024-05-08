package br.com.tresptecnologia.core.exporter.builder;

import br.com.tresptecnologia.core.exporter.ExporterColumn;

import java.util.ArrayList;
import java.util.List;

public final class ExporterColumnBuilder implements IFluentColumnBuilder {

    private final List<ExporterColumn> columns;

    private ExporterColumnBuilder() {
        this.columns = new ArrayList<>();
    }

    public static IFluentColumnBuilder builder() {
        return new ExporterColumnBuilder();
    }

    @Override
    public IFluentColumnBuilder add(String field, String label) {
        columns.add(new ExporterColumn(field, label));
        return this;
    }

    @Override
    public IFluentColumnBuilder parse(List<String> values, String separator) {
        columns.addAll(values.stream().map(value -> {
            String[] split = value.split(separator);
            if (split.length == 3)
                return new ExporterColumn(split[0], split[1], split[2]);

            return new ExporterColumn(split[0], split[1]);
        }).toList());
        return this;
    }

    @Override
    public List<ExporterColumn> build() {
        return columns;
    }
}
