package br.com.tresptecnologia.repository.informacoes;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.notafiscal.InfNFe;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfNFeRepository extends BaseRepository<InfNFe> {
    Optional<InfNFe> findByIdnf(String idnf);
}
