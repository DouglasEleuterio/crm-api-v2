package br.com.tresptecnologia.controller.atendimento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.atendimento.Atendimento;
import br.com.tresptecnologia.model.atendimento.AtendimentoMapper;
import br.com.tresptecnologia.model.atendimento.AtendimentoRequest;
import br.com.tresptecnologia.model.atendimento.AtendimentoResponse;
import br.com.tresptecnologia.service.atendimento.IAtendimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atendimento")
@Tag(name = "Atendimento")
public class AtendimentoController extends BaseRsqlController<Atendimento, AtendimentoRequest, AtendimentoResponse> implements BaseActiveController<Atendimento>, BaseJsonSelectController<Atendimento> {

    private final IAtendimentoService atendimentoService;
    private final AtendimentoMapper atendimentoMapper;

    protected AtendimentoController(final IAtendimentoService service,
                                    final IBaseMapper<Atendimento, AtendimentoRequest, AtendimentoResponse> mapper, AtendimentoMapper atendimentoMapper) {
        super(service, mapper);
        this.atendimentoService = service;
        this.atendimentoMapper = atendimentoMapper;
    }

    @PostMapping
    @Operation(description = "Cria um registro")
    @ResponseStatus(HttpStatus.CREATED)
    public AtendimentoResponse create(@RequestBody AtendimentoRequest entityRequest) throws DomainException {
        return atendimentoService.inserirAtendimento(entityRequest, atendimentoMapper::toResponse);
    }

    @Override
    public IAtendimentoService getService() {
        return atendimentoService;
    }
}
