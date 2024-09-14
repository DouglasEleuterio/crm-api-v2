package br.com.tresptecnologia.model.atendimento;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.atendimento.Atendimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AtendimentoMapper extends IBaseMapper<Atendimento, AtendimentoRequest, AtendimentoResponse> {
}
