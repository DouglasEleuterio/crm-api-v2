package br.com.tresptecnologia.service.confirmacao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.confirmar.ConfirmacaoAgendamentoRequest;
import br.com.tresptecnologia.service.evento.EventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfirmacaoAgendamento implements IConfirmacaoAgendamento {

    private final EventoService eventoService;

    public ConfirmacaoAgendamento(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmar(Long evento, ConfirmacaoAgendamentoRequest confirmacao) throws DomainException {
        var eventoEntity = eventoService.findById(evento);
        eventoEntity.setStart(confirmacao.getDataInicio());
        eventoEntity.setEnd(confirmacao.getDataFim());
        //todo Setar Profissional
        eventoService.update(evento, eventoEntity);
    }
}
