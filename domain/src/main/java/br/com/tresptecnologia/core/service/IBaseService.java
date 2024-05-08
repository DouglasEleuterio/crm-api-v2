package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.entity.BaseEntity;

import java.util.function.Function;

public interface IBaseService<T extends BaseEntity> extends IBaseFindService<T> {

    T create(T entity) throws DomainException;

    T update(Long id, T entity) throws DomainException;

    void delete(Long id) throws DomainException;

    void bind(T entity, T update);

    void validate(T entity) throws DomainException;

    <U> U create(T entity, Function<T, ? extends U> converter) throws DomainException;

    <U> U update(Long id, T entity, Function<T, ? extends U> converter) throws DomainException;

    <U> U map(T entity, Function<T, ? extends U> converter);

    void existsById(final Long id) throws DomainException;
}
