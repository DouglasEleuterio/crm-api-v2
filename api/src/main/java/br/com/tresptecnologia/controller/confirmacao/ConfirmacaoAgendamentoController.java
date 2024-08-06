package br.com.tresptecnologia.controller.confirmacao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.confirmar.ConfirmacaoAgendamentoRequest;
import br.com.tresptecnologia.service.confirmacao.IConfirmacaoAgendamento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirmaragendamento")
@Tag(name = "Confirmação")
public class ConfirmacaoAgendamentoController {

    private final IConfirmacaoAgendamento confirmacaoAgendamento;

    public ConfirmacaoAgendamentoController(IConfirmacaoAgendamento confirmacaoAgendamento) {
        this.confirmacaoAgendamento = confirmacaoAgendamento;
    }

    @PostMapping(path = "/{evento}")
    @Operation(description = "Confirmar Agendamento")
    public ResponseEntity<Void> confirmar(@PathVariable(name = "evento") Long evento, @RequestBody ConfirmacaoAgendamentoRequest confirmacao) throws DomainException {
        confirmacaoAgendamento.confirmar(evento, confirmacao);
        return ResponseEntity.ok().build();
    }
}
