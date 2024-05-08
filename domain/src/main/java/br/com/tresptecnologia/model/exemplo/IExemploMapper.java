package br.com.tresptecnologia.model.exemplo;

import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IExemploMapper extends IBaseMapper<Exemplo, ExemploRequest, ExemploResponse> {
    Exemplo atualizarNomeFromRequest(ExemploNomeRequest exemploRequest);



}
