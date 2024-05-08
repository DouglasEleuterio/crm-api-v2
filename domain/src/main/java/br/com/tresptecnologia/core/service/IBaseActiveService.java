package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.entity.BaseActiveEntity;

public interface IBaseActiveService<T extends BaseActiveEntity> extends IBaseService<T> {
    void active(Long id, boolean ativo) throws DomainException;
}
