package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.core.exception.DomainException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Esta classe é um controle base que contém os métodos padrões para as operações CRUD (Criar, Ler, Atualizar, Excluir)
 * e também o método de consulta utilizando RSQL.
 *
 * @param <T> - Entidade.
 * @param <R> - Classe de requisição.
 * @param <Q> - Classe de resposta.
 */
public abstract class BaseRsqlController<T extends BaseEntity, R, Q extends BaseResponse>
        extends BaseRsqlFindController<T, Q> {

    private final IBaseService<T> service;
    private final IBaseMapper<T, R, Q> mapper;

    /**
     * Construtor da classe BaseRsqlController.
     * @param service - Serviço base para manipulação da entidade.
     * @param mapper - Mapper para mapear as requisições e respostas da entidade.
     */
    protected BaseRsqlController(final IBaseService<T> service, final IBaseMapper<T, R, Q> mapper) {
        super(service, mapper);

        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Método para criar um novo registro.
     * @param entityRequest - Requisição para criação do registro.
     * @return - Resposta contendo o registro criado.
     * @throws DomainException - Exceção de domínio caso ocorra algum erro durante a criação.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @SwaggerGenericResponseType
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Cria um registro")
    public BaseResponse create(@Valid @RequestBody R entityRequest) throws DomainException {
        return service.create(mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    /**
     * Método para atualizar os dados de um registro pelo seu ID.
     * @param id - ID do registro a ser atualizado.
     * @param entityRequest - Requisição contendo os novos dados do registro.
     * @return - Resposta contendo os dados atualizados do registro.
     * @throws DomainException - Exceção de domínio caso ocorra algum erro durante a atualização.
     */
    @SwaggerGenericResponseType
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Atualiza os dados do registro pelo id")
    public BaseResponse update(@PathVariable("id") Long id, @Valid @RequestBody R entityRequest)
            throws DomainException {
        return service.update(id, mapper.fromRequest(entityRequest), mapper::toResponse);
    }

    /**
     * Método para excluir um registro pelo seu ID.
     * @param id - ID do registro a ser excluído.
     * @throws DomainException - Exceção de domínio caso ocorra algum erro durante a exclusão.
     */
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Exclui o registro pelo id. Caso o registro tenha alguma restrição de exclusão, uma validação será retornada.")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws DomainException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
