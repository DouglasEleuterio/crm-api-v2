package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseActiveService<T extends BaseActiveEntity> extends BaseService<T> {
    protected BaseActiveService(BaseRepository<T> repository) {
        super(repository);
    }

    @Transactional(rollbackFor = Exception.class)
    public void active(Long id, boolean ativo) throws DomainException {
        final var entity = findById(id);
        entity.setSituacao(ativo);
        getRepository().save(entity);
    }
}
