package br.com.tresptecnologia.service.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.TabelaAliquotaDiferenciada;
import br.com.tresptecnologia.enumeration.EnumSituacao;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TabelaAliquotaDiferenciadaService extends BaseActiveService<TabelaAliquotaDiferenciada> implements ITabelaAliquotaDiferenciadaService {

    private final JsonMapper jsonMapper;

    protected TabelaAliquotaDiferenciadaService(
            final BaseRepository<TabelaAliquotaDiferenciada> repository,
            final JsonMapper jsonMapper) {
        super(repository);
        this.jsonMapper = jsonMapper;
    }

    @Override
    public TabelaAliquotaDiferenciada create(TabelaAliquotaDiferenciada tabelaAliquotaDiferenciada) throws DomainException {
        tabelaAliquotaDiferenciada.setEnumSituacao(EnumSituacao.ATIVO);
        return super.create(tabelaAliquotaDiferenciada);
    }

    @Override
    public <U> U create(TabelaAliquotaDiferenciada tabelaAliquotaDiferenciada, Function<TabelaAliquotaDiferenciada, ? extends U> converter) throws DomainException {
        tabelaAliquotaDiferenciada.setEnumSituacao(EnumSituacao.ATIVO);
        return super.create(tabelaAliquotaDiferenciada, converter);
    }

    @Override
    public void delete(Long id) throws DomainException {
        var entity = findById(id);
        entity.setSituacao(false);
        super.update(entity.getId(), entity);
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

}
