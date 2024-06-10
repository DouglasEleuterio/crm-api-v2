package br.com.tresptecnologia.repository.cliente;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.historico.Historico;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends BaseRepository<Historico> {
}
