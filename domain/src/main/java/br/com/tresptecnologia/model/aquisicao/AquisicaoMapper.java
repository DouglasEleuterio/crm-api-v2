package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AquisicaoMapper extends IBaseMapper<Aquisicao, AquisicaoRequest, AquisicaoResponse> {
}
