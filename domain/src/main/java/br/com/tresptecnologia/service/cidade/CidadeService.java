package br.com.tresptecnologia.service.cidade;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.cliente.Cidade;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends BaseService<Cidade> implements ICidadeService {

    private final JsonMapper jsonMapper;

    protected CidadeService(BaseRepository<Cidade> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
