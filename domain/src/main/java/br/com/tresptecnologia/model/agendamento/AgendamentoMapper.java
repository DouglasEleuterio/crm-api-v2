package br.com.tresptecnologia.model.agendamento;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.Agendamento;
import br.com.tresptecnologia.entity.evento.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper extends IBaseMapper<Agendamento, AgendamentoRequest, AgendamentoResponse> {

    Agendamento toAgendamento(Evento evento);

    Evento toEvento(Agendamento agendamento);
}
