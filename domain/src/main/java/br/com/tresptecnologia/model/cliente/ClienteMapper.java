package br.com.tresptecnologia.model.cliente;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.cliente.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends IBaseMapper<Cliente, ClienteRequest, ClienteResponse> {
}
