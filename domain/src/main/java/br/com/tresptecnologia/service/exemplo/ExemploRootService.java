package br.com.tresptecnologia.service.exemplo;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.benchmark.ExemploRoot;
import br.com.tresptecnologia.repository.benchmark.ExemploRootRepository;
import org.springframework.stereotype.Service;

@Service
public class ExemploRootService extends BaseService<ExemploRoot> implements IExemploRootService {

    private final JsonMapper jsonMapper;

    protected ExemploRootService(final ExemploRootRepository repository,
                                 final JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public ExemploRootRepository getRepository() {
        return (ExemploRootRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
