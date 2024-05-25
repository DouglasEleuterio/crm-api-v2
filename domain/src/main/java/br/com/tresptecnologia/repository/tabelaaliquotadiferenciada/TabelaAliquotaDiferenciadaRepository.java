package br.com.tresptecnologia.repository.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.TabelaAliquotaDiferenciada;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TabelaAliquotaDiferenciadaRepository extends BaseRepository<TabelaAliquotaDiferenciada> {
    Optional<TabelaAliquotaDiferenciada> findByNcm(String ncm);
}
