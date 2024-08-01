package br.com.tresptecnologia.repository.aquisicao;

import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AquisicaoProcedimentoRepository extends JpaRepository<AquisicaoProcedimento, Long> {
}
