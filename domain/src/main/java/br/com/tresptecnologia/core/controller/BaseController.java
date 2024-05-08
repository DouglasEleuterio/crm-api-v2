package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.core.exception.DomainException;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Controle base que contém os métodos padrões de crud
 *
 * @param <T> - Entidade.
 * @param <R> - Classe de requisição.
 * @param <Q> - Classe de resposta.
 */
public abstract class BaseController<T extends BaseEntity, R, Q> {

    private final IBaseService<T> service;
    private final IBaseMapper<T, R, Q> mapper;

    protected BaseController(final IBaseService<T> service, final IBaseMapper<T, R, Q> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PageableAsQueryParam
    @Operation(description = "Consulta os registros com paginação")
    public Page<Object> findPage(@SortDefault(sort = "id") Pageable pageable) {
        return service.findAll(pageable, mapper::toResponse);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta todos os registros sem paginação")
    public List<Object> findAll(@SortDefault(sort = "id") Sort sort) {
        return service.findAll(sort, mapper::toResponse);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta o registro pelo id")
    public Object findById(@PathVariable Long id) throws DomainException {
        return service.findById(id, mapper::toResponse);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cria um registro")
    public Object create(@Valid @RequestBody R entityRequest) throws DomainException {
        return service.create(mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Atualiza o registro")
    public Object update(@PathVariable("id") Long id, @Valid @RequestBody R entityRequest)
        throws DomainException {
        return service.update(id, mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    @DeleteMapping(path = "/{id}")
    @Operation(description = "Deleta o registro por id")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws DomainException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    protected IBaseService<T> getService() {
        return service;
    }

    protected IBaseMapper<T, R, Q> getMapper() {
        return mapper;
    }

}
