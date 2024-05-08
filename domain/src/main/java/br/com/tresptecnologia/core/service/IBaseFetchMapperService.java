package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.jpa.mapper.Row;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface IBaseFetchMapperService<T extends BaseEntity> {

    BaseRepository<T> getRepository();

    JsonMapper getJsonMapper();

    default <U> List<U> fetch(final List<String> columns, final Specification<T> spec, Class<U> response) {
        List<Row> rows = getRepository().fetch(columns, spec);
        return getJsonMapper().toListModel(rows, response);
    }

    default <U> List<U> fetch(final List<String> columns, final Specification<T> spec, Sort sort, Class<U> response) {
        List<Row> rows = getRepository().fetch(columns, spec, sort);
        return getJsonMapper().toListModel(rows, response);
    }

    default <U> List<U> fetch(final List<String> columns, final Specification<T> spec, Integer page, Integer size, Class<U> response) {
        List<Row> rows = getRepository().fetch(columns, spec, page, size);
        return getJsonMapper().toListModel(rows, response);
    }

    default <U> List<U> fetch(final List<String> columns, final Specification<T> spec, Integer page, Integer size, Sort sort, Class<U> response) {
        List<Row> rows = getRepository().fetch(columns, spec, page, size, sort);
        return getJsonMapper().toListModel(rows, response);
    }

    default <U> Page<U> fetch(final Specification<T> spec, Pageable pageable, Class<U> response, final String... columns) {
        return fetch(Arrays.asList(columns), spec, pageable, response);
    }

    default <U> Page<U> fetch(final List<String> columns, final Specification<T> spec, Pageable pageable, Class<U> response) {
        Page<Row> page = getRepository().fetch(columns, spec, pageable);
        return new PageImpl<>(getJsonMapper().toListModel(
                page.stream().collect(Collectors.toList()), response
        ), pageable, page.getTotalElements());
    }

    default ArrayNode fetchJson(final List<String> columns,
                                final Specification<T> spec,
                                final Pageable pageable) {
        Page<Row> rows = getRepository().fetch(columns, spec, pageable);
        return getJsonMapper().toJsonArray(rows.toList());
    }

    default BaseJsonNode findAll(
            final String stringColumns,
            final @Nullable Specification<T> spec,
            final @Nullable Integer page,
            final @Nullable Integer size,
            final Sort sort) throws DomainException {

        if (StringUtils.isBlank(stringColumns)) {
            throw new DomainException("A lista de colunas é obrigatoria");
        }

        final List<String> columns = Arrays.asList(stringColumns.trim().split(","));
        if (columns.isEmpty()) {
            throw new DomainException("A lista de colunas é obrigatoria");
        }

        if (size != null) {
            final boolean hasPage = page != null;
            final Pageable pageable = hasPage ? PageRequest.of(page, size, sort)
                    : PageRequest.ofSize(size).withSort(sort);
            final Page<Row> rows = getRepository().fetch(columns, spec, pageable);
            return hasPage ? getJsonMapper().toJsonPage(rows) :
                    getJsonMapper().toJsonArray(rows.stream().toList());
        }

        final List<Row> rows = getRepository().fetch(columns, spec, sort);
        return getJsonMapper().toJsonArray(rows.stream().toList());
    }

}
