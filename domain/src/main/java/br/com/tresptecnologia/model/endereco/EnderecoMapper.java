package br.com.tresptecnologia.model.endereco;

import br.com.tresptecnologia.core.mapper.IBaseRequestMapper;
import br.com.tresptecnologia.entity.cliente.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends IBaseRequestMapper<Endereco, EnderecoRequest> {
}
