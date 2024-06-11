package br.com.tresptecnologia.repository.pagamento;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends BaseRepository<Pagamento> {
}
