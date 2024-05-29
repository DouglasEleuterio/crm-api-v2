package br.com.tresptecnologia.model.produto;

import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.entity.notafiscal.Prod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdMapper extends IBaseResponseMapper<Prod, ProdIncidenciaMonoResponse> {
}
