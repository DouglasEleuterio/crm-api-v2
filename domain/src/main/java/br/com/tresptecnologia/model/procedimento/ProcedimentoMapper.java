package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProcedimentoMapper extends IBaseMapper<Procedimento, ProcedimentoRequest, ProcedimentoResponse> {
}
