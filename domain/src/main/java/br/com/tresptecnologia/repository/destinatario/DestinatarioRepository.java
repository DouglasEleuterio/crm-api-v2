package br.com.tresptecnologia.repository.destinatario;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.notafiscal.Dest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DestinatarioRepository extends BaseRepository<Dest> {
    @Query(value = "select distinct dest.cnpj from Dest dest")
    List<String> getAllCnpj();
}
