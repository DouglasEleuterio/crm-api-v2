package br.com.tresptecnologia.service.exemplo.relacao;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.ExemploRelacao;
import org.springframework.stereotype.Service;

@Service
public class ExemploRelacaoService extends BaseService<ExemploRelacao> implements IExemploRelacaoService {

    protected ExemploRelacaoService(final BaseRepository<ExemploRelacao> repository) {
        super(repository);
    }

}
