package br.com.tresptecnologia.service.profissional;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.profissional.Profissional;
import org.springframework.stereotype.Service;

@Service
public class ProfissionalService extends BaseActiveService<Profissional> implements IProfissionalService {

    private final JsonMapper jsonMapper;

    public ProfissionalService(final BaseRepository<Profissional> repository,
                               final JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
