package br.com.tresptecnologia.service.parcelapagamento;

import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.pagamento.ParcelaPagamento;
import org.springframework.stereotype.Service;

@Service
public class ParcelaPagamentoService extends BaseActiveService<ParcelaPagamento> implements IParcelaPagamentoService {

    private final JsonMapper jsonMapper;

    protected ParcelaPagamentoService(BaseRepository<ParcelaPagamento> repository, JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
