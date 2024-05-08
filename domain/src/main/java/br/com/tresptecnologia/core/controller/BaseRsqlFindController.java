package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.core.controller.constants.BaseControllerConstants;
import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Esta classe é um controle base que contém os métodos padrões para consulta e também o método de consulta utilizando RSQL.
 *
 * @param <T> - Tipo da entidade.
 * @param <Q> - Classe de resposta.
 */
public abstract class BaseRsqlFindController<T extends BaseEntity, Q extends BaseResponse> {

    private final IBaseService<T> service;
    private final IBaseResponseMapper<T, Q> mapper;

    /**
     * Construtor da classe BaseRsqlFindController.
     *
     * @param service - Serviço base para manipulação da entidade.
     * @param mapper  - Mapper para mapear as respostas da entidade.
     */
    protected BaseRsqlFindController(final IBaseService<T> service,
                                     final IBaseResponseMapper<T, Q> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Método para consulta dos dados com paginação e filtragem utilizando RSQL.
     *
     * @param search - Consulta RSQL para filtrar os dados.
     * @param page,  size - Configurações de paginação.
     * @return - Página contendo os resultados da consulta.
     */
    @SwaggerGenericResponseType
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta os dados paginando e filtrando utilizando o padrão **RSQL**")
    public Iterable<? extends BaseResponse> findPage(
            @Parameter(description = BaseControllerConstants.FIND_PAGE_DOC)
            @RequestParam(required = false) String search,
            @SortDefault(sort = "id")
            Sort sort,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        final Specification<T> spec = SpecificationUtils.rsqlToSpecification(search);
        return getService().findAll(spec, page, size, sort, getMapper()::toResponse);
    }


    /**
     * Método para consulta de um registro pelo seu ID.
     *
     * @param id - ID do registro a ser consultado.
     * @return - Resposta contendo os dados do registro consultado.
     * @throws DomainException - Exceção de domínio caso ocorra algum erro durante a consulta.
     */
    @SwaggerGenericResponseType
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta o registro pelo id")
    public BaseResponse findById(@PathVariable Long id) throws DomainException {
        return service.findById(id, mapper::toResponse);
    }

    /**
     * Método para obter o serviço base.
     *
     * @return - Serviço base para manipulação da entidade.
     */
    protected IBaseService<T> getService() {
        return service;
    }

    /**
     * Método para obter o mapper de resposta.
     *
     * @return - Mapper para mapear as respostas da entidade.
     */
    protected IBaseResponseMapper<T, Q> getMapper() {
        return mapper;
    }

}
