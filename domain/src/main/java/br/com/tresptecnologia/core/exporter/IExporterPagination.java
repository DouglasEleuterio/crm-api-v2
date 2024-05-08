package br.com.tresptecnologia.core.exporter;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IExporterPagination {
    <T> List<IExporterValue> fetch(Specification<T> spec, List<ExporterColumn> columns, int first, int size, Sort sort, Class<T> clazz);
}
