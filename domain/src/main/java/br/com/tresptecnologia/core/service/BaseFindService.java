package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.List;

public abstract class BaseFindService<T extends BaseEntity> implements IBaseFindService<T> {

    private static final String ERROR_PROPERTY = "error.notfound";
    private final BaseRepository<T> repository;

    protected BaseFindService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(@Nullable Specification<T> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public T findById(Long id) throws DomainException {
        return repository
                .findById(id)
                .orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
    }

    public BaseRepository<T> getRepository() {
        return this.repository;
    }

}
