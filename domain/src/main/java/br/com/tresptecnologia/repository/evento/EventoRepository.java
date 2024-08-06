package br.com.tresptecnologia.repository.evento;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.evento.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends BaseRepository<Evento> {

    @Query(value = "from Evento e where e.confirmado =:confirmado and (:profssionalId is null or e.profissional.id =:profssionalId) ")
    List<Evento> findAllByConfirmadoAndProfissionalId(Boolean confirmado, Long profssionalId);
}
