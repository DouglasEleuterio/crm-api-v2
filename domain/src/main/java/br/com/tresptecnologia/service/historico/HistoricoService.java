package br.com.tresptecnologia.service.historico;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.historico.Historico;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService extends BaseService<Historico> implements IHistoricoService{
    protected HistoricoService(BaseRepository<Historico> repository) {
        super(repository);
    }
}
