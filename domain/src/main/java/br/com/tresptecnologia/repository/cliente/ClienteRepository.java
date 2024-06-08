package br.com.tresptecnologia.repository.cliente;


import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.cliente.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente> {
}
