package br.com.tresptecnologia.model.auditoria;

import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.entity.historico.Auditoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditoriaMapper extends IBaseResponseMapper<Auditoria, AuditoriaResponse> {
}
