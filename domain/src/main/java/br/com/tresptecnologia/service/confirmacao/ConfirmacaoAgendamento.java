package br.com.tresptecnologia.service.confirmacao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.confirmar.ConfirmacaoAgendamentoRequest;
import br.com.tresptecnologia.service.evento.EventoService;
import br.com.tresptecnologia.service.profissional.ProfissionalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfirmacaoAgendamento implements IConfirmacaoAgendamento {

    private final EventoService eventoService;
    private final ProfissionalService profissionalService;

    public ConfirmacaoAgendamento(EventoService eventoService, ProfissionalService profissionalService) {
        this.eventoService = eventoService;
        this.profissionalService = profissionalService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmar(Long evento, ConfirmacaoAgendamentoRequest confirmacao) throws DomainException {
        var eventoEntity = eventoService.findById(evento);
        eventoEntity.setStart(confirmacao.getDataInicio());
        eventoEntity.setEnd(confirmacao.getDataFim());
        eventoEntity.setProfissional(profissionalService.findById(confirmacao.getProfissional().getId()));
        //todo Setar Profissional
        eventoService.update(evento, eventoEntity);
    }
}
