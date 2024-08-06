package br.com.tresptecnologia.service.confirmacao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.confirmar.ConfirmacaoAgendamentoRequest;

public interface IConfirmacaoAgendamento {

    void confirmar(Long evento, ConfirmacaoAgendamentoRequest confirmacao) throws DomainException;
}
