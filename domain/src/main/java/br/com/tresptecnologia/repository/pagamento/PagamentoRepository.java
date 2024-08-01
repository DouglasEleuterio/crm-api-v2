package br.com.tresptecnologia.repository.pagamento;

import br.com.tresptecnologia.entity.pagamento.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
