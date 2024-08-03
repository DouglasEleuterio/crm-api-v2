package br.com.tresptecnologia.repository.evento;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.evento.Evento;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends BaseRepository<Evento> {
}
