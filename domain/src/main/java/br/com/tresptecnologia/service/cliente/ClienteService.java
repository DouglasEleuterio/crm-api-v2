package br.com.tresptecnologia.service.cliente;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.repository.cliente.ClienteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseActiveService<Cliente> implements IClienteService {

    private final JsonMapper jsonMapper;
    ObjectMapper objectMapper = new ObjectMapper();

    protected ClienteService(BaseRepository<Cliente> repository, JsonMapper jsonMapper) {
        super(repository);
        objectMapper.registerModule(new JavaTimeModule());
        this.jsonMapper = jsonMapper;
    }

    public ClienteRepository getRepository() {
        return (ClienteRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    public Cliente update(Long id, Cliente updateT) throws DomainException {
        var oldOjb = getRepository().findById(id);
        try {
            var newJson = objectMapper.writeValueAsString(updateT);
            var oldJson = objectMapper.writeValueAsString(oldOjb);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return super.update(id, updateT);
    }
}
