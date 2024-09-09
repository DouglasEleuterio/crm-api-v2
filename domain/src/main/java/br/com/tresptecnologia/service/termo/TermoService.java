package br.com.tresptecnologia.service.termo;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.termo.Termo;
import br.com.tresptecnologia.repository.termo.TermoRepository;
import org.springframework.stereotype.Service;

@Service
public class TermoService extends BaseActiveService<Termo> implements ITermoService {

    private final JsonMapper jsonMapper;

    protected TermoService(BaseRepository<Termo> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Termo create(Termo termo) throws DomainException {
        termo.setVersao(getRepository().countByProcedimento_Id(termo.getProcedimento().getId())+1);
        return super.create(termo);
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    public TermoRepository getRepository() {
        return (TermoRepository) super.getRepository();
    }
}
