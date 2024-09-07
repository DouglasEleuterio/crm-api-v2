package br.com.tresptecnologia.service.confirmacao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.Agendamento;
import br.com.tresptecnologia.model.agendamento.AgendamentoMapperImpl;
import br.com.tresptecnologia.model.confirmar.ConfirmacaoAgendamentoRequest;
import br.com.tresptecnologia.service.agendamento.AgendamentoService;
import br.com.tresptecnologia.service.color.ColorEventoService;
import br.com.tresptecnologia.service.evento.EventoService;
import br.com.tresptecnologia.service.profissional.ProfissionalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ConfirmacaoAgendamento implements IConfirmacaoAgendamento {

    private final EventoService eventoService;
    private final ProfissionalService profissionalService;
    private final AgendamentoMapperImpl agendamentoMapperImpl;
    private final AgendamentoService agendamentoService;
    private final ColorEventoService colorEventoService;

    public ConfirmacaoAgendamento(EventoService eventoService, ProfissionalService profissionalService, AgendamentoMapperImpl agendamentoMapperImpl, AgendamentoService agendamentoService, ColorEventoService colorEventoService) {
        this.eventoService = eventoService;
        this.profissionalService = profissionalService;
        this.agendamentoMapperImpl = agendamentoMapperImpl;
        this.agendamentoService = agendamentoService;
        this.colorEventoService = colorEventoService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmar(Long evento, ConfirmacaoAgendamentoRequest confirmacao) throws DomainException {
        var eventoEntity = eventoService.findById(evento);
        eventoEntity.setStart(confirmacao.getDataInicio());
        eventoEntity.setEnd(confirmacao.getDataFim());
        eventoEntity.setProfissional(profissionalService.findById(confirmacao.getProfissional().getId()));
        //todo Setar Profissional
        var agendamento = (Agendamento) agendamentoMapperImpl.toAgendamento(eventoEntity);
        agendamento.setDataCriacao(eventoEntity.getDataCriacao());
        agendamento.setSituacao(eventoEntity.getSituacao());
        agendamento.setBackgroundColor(colorEventoService.getColorByProcedimento(agendamento.getTitle()));
        agendamento.setDataAtualizacao(LocalDateTime.now());
        agendamentoService.create(agendamento);
        eventoService.delete(evento);
    }
}
