package br.com.tresptecnologia.model.termo;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.termo.Termo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TermoMapper extends IBaseMapper<Termo, TermoRequest, TermoResponse> {
}
