package br.com.tresptecnologia.repository.cliente;


import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.cliente.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente> {
    Optional<Cliente> findByCpf(String cpf);
}
