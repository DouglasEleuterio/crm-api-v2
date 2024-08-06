package br.com.tresptecnologia.repository.regiao;

import br.com.tresptecnologia.entity.procedimento.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
}
