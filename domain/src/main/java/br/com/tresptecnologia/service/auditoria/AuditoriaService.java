package br.com.tresptecnologia.service.auditoria;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseService;
import br.com.tresptecnologia.entity.historico.Auditoria;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService extends BaseService<Auditoria> implements IAuditoriaService{
    protected AuditoriaService(BaseRepository<Auditoria> repository) {
        super(repository);
    }
}
