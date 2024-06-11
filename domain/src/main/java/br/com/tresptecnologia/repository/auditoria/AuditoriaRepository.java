package br.com.tresptecnologia.repository.auditoria;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.historico.Auditoria;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends BaseRepository<Auditoria> {
}
