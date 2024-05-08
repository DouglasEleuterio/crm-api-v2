package br.com.tresptecnologia.core.exporter;

import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import br.com.tresptecnologia.core.exporter.model.ExporterRequest;

public interface IExporterService {
    <T> ExporterData export(Class<T> clazz,
                            ExporterRequest request,
                            ExporterType exporterType) throws ExporterException;
}
