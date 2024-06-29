package br.com.tresptecnologia.service;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import org.springframework.stereotype.Service;

@Service
public class AquisicaoProcedimentoService extends BaseService<AquisicaoProcedimento> {
    protected AquisicaoProcedimentoService(BaseRepository<AquisicaoProcedimento> repository) {
        super(repository);
    }
}
