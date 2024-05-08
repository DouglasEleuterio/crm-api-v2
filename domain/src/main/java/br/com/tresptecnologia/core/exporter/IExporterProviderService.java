package br.com.tresptecnologia.core.exporter;

import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface IExporterProviderService {
    <T> ExporterData export(final ExporterConfig config,
                            final Specification<T> specification,
                            final Sort sort,
                            final Class<T> clazz) throws ExporterException;
}
