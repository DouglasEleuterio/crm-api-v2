package br.com.tresptecnologia.service.estado;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.cliente.Estado;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends BaseService<Estado> implements IEstadoService {

    private final JsonMapper jsonMapper;

    protected EstadoService(BaseRepository<Estado> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
