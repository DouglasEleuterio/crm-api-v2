package br.com.tresptecnologia.service.cliente;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.repository.cliente.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseActiveService<Cliente> implements IClienteService {

    private final JsonMapper jsonMapper;

    protected ClienteService(BaseRepository<Cliente> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    public ClienteRepository getRepository() {
        return (ClienteRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
