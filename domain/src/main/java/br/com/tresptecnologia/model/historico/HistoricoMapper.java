package br.com.tresptecnologia.model.historico;

import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.entity.historico.Historico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoricoMapper extends IBaseResponseMapper<Historico, HistoricoResponse> {
}
