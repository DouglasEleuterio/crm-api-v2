package br.com.tresptecnologia.service.procedimento;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ProcedimentoService extends BaseActiveService<Procedimento> implements IProcedimentoService {

    private final JsonMapper jsonMapper;

    protected ProcedimentoService(BaseRepository<Procedimento> repository,
                                  JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

}
