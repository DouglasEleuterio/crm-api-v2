package br.com.tresptecnologia.core.exporter.format;

public interface IExporterValueFormat {
    Object format(Object value, String format);
    boolean apply(Object value);
}
