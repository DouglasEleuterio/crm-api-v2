package br.com.tresptecnologia.model.evento;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.evento.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper extends IBaseMapper<Evento, EventoRequest, EventoResponse> {
}
