package br.com.tresptecnologia.service.historico;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.historico.Historico;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService extends BaseService<Historico> implements IHistoricoService{

    private final JsonMapper jsonMapper;

    protected HistoricoService(BaseRepository<Historico> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
