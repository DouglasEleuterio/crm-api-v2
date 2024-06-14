package br.com.tresptecnologia.service.cliente;


import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.cliente.Cliente;

import java.util.Optional;

public interface IClienteService extends IBaseActiveService<Cliente>, IBaseFetchMapperService<Cliente> {
    Optional<Cliente> findByCPF(String cpf);
}
