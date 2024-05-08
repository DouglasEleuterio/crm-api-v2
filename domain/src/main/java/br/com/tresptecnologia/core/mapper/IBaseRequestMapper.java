package br.com.tresptecnologia.core.mapper;

import br.com.tresptecnologia.core.entity.BaseEntity;

/**
 * Classe base de mapeamento de entidades
 *
 * @param <T> - Entidade.
 * @param <R> - Classe de requisição.
 */
public interface IBaseRequestMapper<T extends BaseEntity, R> {
    T fromRequest(R request);

    R toRequest(T entity);
}
