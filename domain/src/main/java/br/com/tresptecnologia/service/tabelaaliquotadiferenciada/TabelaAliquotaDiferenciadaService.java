package br.com.tresptecnologia.service.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.TabelaAliquotaDiferenciada;
import br.com.tresptecnologia.enumeration.EnumSituacao;
import br.com.tresptecnologia.repository.tabelaaliquotadiferenciada.TabelaAliquotaDiferenciadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public TabelaAliquotaDiferenciada create(TabelaAliquotaDiferenciada tabelaAliquotaDiferenciada) throws DomainException {
        tabelaAliquotaDiferenciada.setEnumSituacao(EnumSituacao.ATIVO);
        tabelaAliquotaDiferenciada.setSituacao(true);
        var aliquotaOtp = ((TabelaAliquotaDiferenciadaRepository) getRepository())
                .findByNcm(tabelaAliquotaDiferenciada.getNcm());
        if (aliquotaOtp.isPresent())
            throw new DomainException(Message.toLocale("ncm-error.duplicado"));
        return super.create(tabelaAliquotaDiferenciada);
    }

    @Override
    public void delete(Long id) throws DomainException {
        var entity = findById(id);
        entity.setEnumSituacao(EnumSituacao.INATIVO);
        super.update(entity.getId(), entity);
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

}
