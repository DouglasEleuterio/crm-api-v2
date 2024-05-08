package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.core.controller.constants.BaseControllerConstants;
import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseJsonSelectController<T extends BaseEntity> {

    IBaseFetchMapperService<T> getService();

    /**
     * Método para consulta dos dados com paginação, filtragem utilizando RSQL
     * e opção de informar as colunas que deseja consultar
     *
     * @param columns - Lista de colunas separadas por virgula.
     * @param search  - Consulta RSQL para filtrar os dados.
     * @param page,   size - Configurações de paginação.
     * @return - Página contendo os resultados da consulta.
     */
    @SwaggerGenericResponseType
    @GetMapping(path = "/select", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta os dados paginando e filtrando utilizando o padrão **RSQL**")
    default BaseJsonNode findSelect(
            @Parameter(description = BaseControllerConstants.FIND_PAGE_DOC)
            @RequestParam(required = false) String search,
            @Parameter(description = BaseControllerConstants.FIND_COLUMNS_DOC)
            @RequestParam String columns,
            @SortDefault(sort = "id")
            Sort sort,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) throws DomainException {

        final Specification<T> spec = SpecificationUtils.rsqlToSpecification(search);
        return getService().findAll(columns, spec, page, size, sort);
    }


}
