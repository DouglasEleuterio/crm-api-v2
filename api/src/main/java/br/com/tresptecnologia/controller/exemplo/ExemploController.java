package br.com.tresptecnologia.controller.exemplo;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseExporterController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.controller.constants.BaseControllerConstants;
import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.exporter.IExporterService;
import br.com.tresptecnologia.core.security.AuthorityAllowed;
import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.exemplo.ExemploNomeRequest;
import br.com.tresptecnologia.model.exemplo.ExemploRequest;
import br.com.tresptecnologia.model.exemplo.ExemploResponse;
import br.com.tresptecnologia.model.exemplo.IExemploMapper;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import br.com.tresptecnologia.service.auth.authority.ExemploAuthority;
import br.com.tresptecnologia.service.exemplo.IExemploService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exemplo de implementação de um controller utilizando as classes abstratas
 * Este controle serve apenas para exemplo e deve ser removido quando o projeto for entregue
 */
@RestController
@RequestMapping("/exemplos")
@Tag(name = "Exemplos")
public class ExemploController extends BaseRsqlController<Exemplo, ExemploRequest, ExemploResponse>
        implements BaseActiveController<Exemplo>, BaseExporterController<Exemplo>,
        BaseJsonSelectController<Exemplo> {

    private final IExporterService exporterService;

    protected ExemploController(final IExemploService service,
                                final IExemploMapper mapper,
                                final IExporterService exporterService) {
        super(service, mapper);
        this.exporterService = exporterService;
    }

    @PageableAsQueryParam
    @SwaggerGenericResponseType
    @GetMapping(path = "/paginate-jsonmapper", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Consulta os dados paginando e filtrando utilizando o padrão **RSQL**")
    public Page<? extends BaseResponse> findPagePaginateJsonMapper(
            @Parameter(description = BaseControllerConstants.FIND_PAGE_DOC)
            @RequestParam(required = false) String search,
            @SortDefault(sort = "id")
            Pageable pageable) {
        return getService().findAllJsonMapper(SpecificationUtils.rsqlToSpecification(search), pageable);
    }

    @AuthorityAllowed({ExemploAuthority.UPDATE_NAME})
    @PatchMapping(path = "/atualizar-nome/{id}")
    @Operation(description = "Atualizar o nome do exemplo")
    public ExemploResponse atualizarNome(@PathVariable("id") Long id, @Valid @RequestBody ExemploNomeRequest entityRequest)
            throws DomainException {

        final var request = getMapper().atualizarNomeFromRequest(entityRequest);
        final var response = getService().atualizarNome(id, request);
        return getService().map(response, getMapper()::toResponse);
    }

    @Override
    public IExemploService getService() {
        return (IExemploService) super.getService();
    }

    @Override
    public IExemploMapper getMapper() {
        return (IExemploMapper) super.getMapper();
    }

    @Override
    public IExporterService getExporterService() {
        return exporterService;
    }
}
