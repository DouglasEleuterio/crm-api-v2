package br.com.tresptecnologia.controller.agendamento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.agendamento.Agendamento;
import br.com.tresptecnologia.model.agendamento.AgendamentoRequest;
import br.com.tresptecnologia.model.agendamento.AgendamentoResponse;
import br.com.tresptecnologia.model.agendamento.AlterarAgendamentoRequest;
import br.com.tresptecnologia.service.agendamento.IAgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamento")
@Tag(name = "Agendamentos")
public class AgendamentoController extends BaseRsqlController<Agendamento, AgendamentoRequest, AgendamentoResponse>
        implements BaseActiveController<Agendamento>, BaseJsonSelectController<Agendamento> {
    /**
     * Construtor da classe BaseRsqlController.
     *
     * @param service - Serviço base para manipulação da entidade.
     * @param mapper  - Mapper para mapear as requisições e respostas da entidade.
     */
    protected AgendamentoController(IBaseService<Agendamento> service,
                                    IBaseMapper<Agendamento, AgendamentoRequest, AgendamentoResponse> mapper) {
        super(service, mapper);
    }

    @PostMapping(path = "/alteraragendamento/{agendamento}")
    @Operation(description = "Confirmar Agendamento")
    public ResponseEntity<Void> confirmar(@PathVariable(name = "agendamento") Long agendamento,
                                          @RequestBody AlterarAgendamentoRequest confirmacao) throws DomainException {
        getService().confirmar(agendamento, confirmacao);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/cancelaragendamento/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable final Long id) throws DomainException {
        getService().cancelarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public IAgendamentoService getService() {
        return (IAgendamentoService) super.getService();
    }
}
