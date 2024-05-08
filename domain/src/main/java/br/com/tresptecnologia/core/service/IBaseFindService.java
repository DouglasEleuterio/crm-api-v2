package br.com.tresptecnologia.core.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

public interface IBaseFindService<T extends BaseEntity> {

    T findById(Long id) throws DomainException;

    <U> U findById(Long id, Function<T, ? extends U> converter) throws DomainException;

    <U> Page<U> findAll(@Nullable Specification<T> spec, Pageable pageable, Function<T, ? extends U> converter);

    <U> List<U> findAll(@Nullable Specification<T> spec, Sort sort, Function<T, ? extends U> converter);

    <U> List<U> findAll(@Nullable Specification<T> spec, Function<T, ? extends U> converter);

    <U> Page<U> findAll(Pageable pageable, Function<T, ? extends U> converter);

    <U> List<U> findAll(Sort sort, Function<T, ? extends U> converter);

    Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);

    List<T> findAll(@Nullable Specification<T> spec, Sort sort);

    Page<T> findAll(Pageable pageable);

    List<T> findAll(Sort sort);

    @Transactional(readOnly = true)
    default <U> Iterable<? extends U> findAll(@Nullable Specification<T> spec,
                                              @Nullable Integer page,
                                              @Nullable Integer size,
                                              Sort sort,
                                              Function<T, ? extends U> converter) {
        if (page != null && size != null) {
            Pageable pageable = PageRequest.of(page, size, sort);
            return findAll(spec, pageable, converter);
        }
        if (size != null) {
            final PageRequest pageRequest = PageRequest.ofSize(size)
                    .withSort(sort);
            return findAll(spec, pageRequest, converter).getContent();
        }
        return findAll(spec, sort, converter);
    }

}
