package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.message.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

    protected static final String ERROR_PROPERTY = "error.notfound";
    private final BaseRepository<T> repository;

    protected BaseService(BaseRepository<T> repository) {
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
    public <U> Page<U> findAll(Specification<T> spec, Pageable pageable, Function<T, ? extends U> converter) {
        return findAll(spec, pageable).map(converter);
    }

    @Override
    public <U> List<U> findAll(Specification<T> spec, Sort sort, Function<T, ? extends U> converter) {
        return repository.findAll(spec, sort).stream().map(converter)
                .collect(Collectors.toList());
    }

    @Override
    public <U> Page<U> findAll(Pageable pageable, Function<T, ? extends U> converter) {
        return repository.findAll(pageable).map(converter);
    }

    @Override
    public <U> List<U> findAll(Sort sort, Function<T, ? extends U> converter) {
        return repository.findAll(sort).stream().map(converter)
                .collect(Collectors.toList());
    }

    @Override
    public <U> List<U> findAll(Specification<T> spec, Function<T, ? extends U> converter) {
        return repository.findAll(spec).stream().map(converter)
                .collect(Collectors.toList());
    }

    @Override
    public <U> U findById(Long id, Function<T, ? extends U> converter) throws DomainException {
        final var entity = repository
                .findById(id)
                .orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
        return converter.apply(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public <U> U create(T t, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(this.create(t));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public <U> U update(Long id, T updateT, Function<T, ? extends U> converter) throws DomainException {
        return converter.apply(this.update(id, updateT));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T create(T t) throws DomainException {
        validate(t);
        return repository.save(t);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T update(Long id, T updateT) throws DomainException {
        final T t =
                repository
                        .findById(id)
                        .orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
        validate(updateT);
        bind(t, updateT);
        return repository.save(t);
    }

    public void validateDelete(T t) throws DomainException {
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws DomainException {
        final T t = repository.findById(id).orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
        validateDelete(t);
        repository.delete(t);
    }

    @Override
    public T findById(Long id) throws DomainException {
        return repository
                .findById(id)
                .orElseThrow(() -> new DomainException(Message.toLocale(ERROR_PROPERTY, id)));
    }

    @Override
    public void existsById(final Long id) throws DomainException {
        if (Boolean.FALSE.equals(repository.existsById(id))) {
            throw new DomainException(Message.toLocale(ERROR_PROPERTY, id));
        }
    }

    @Override
    public void validate(T entity) throws DomainException {
        if (Objects.isNull(entity)) {
            throw new DomainException("error.entity-null");
        }
    }

    @Override
    public <U> U map(T entity, Function<T, ? extends U> converter) {
        return converter.apply(entity);
    }

    @Override
    public void bind(T entity, T update) {
        BeanUtils.copyProperties(update, entity, "id", "situacao", "dataCriacao", "dataAtualizacao");
    }

    public BaseRepository<T> getRepository() {
        return this.repository;
    }

}
