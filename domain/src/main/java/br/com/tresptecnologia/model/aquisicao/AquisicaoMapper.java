package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AquisicaoMapper extends IBaseMapper<Aquisicao, AquisicaoRequest, AquisicaoResponse> {
}
