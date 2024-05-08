package br.com.tresptecnologia.model.exemplo.relacao;

import br.com.tresptecnologia.entity.ExemploRelacao;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IExemploRelacaoMapper extends IBaseMapper<ExemploRelacao, ExemploRelacaoRequest, ExemploRelacaoResponse> {

}
