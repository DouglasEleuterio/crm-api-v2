package br.com.tresptecnologia.service.pagamento;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.repository.pagamento.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends BaseActiveService<Pagamento> implements IPagamentoService {

    private final JsonMapper jsonMapper;

    protected PagamentoService(PagamentoRepository repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
