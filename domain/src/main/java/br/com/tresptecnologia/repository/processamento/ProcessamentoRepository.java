package br.com.tresptecnologia.repository.processamento;

import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.entity.processamento.Processamento;
import br.com.tresptecnologia.enumeration.ESituacaoProcessamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessamentoRepository extends BaseRepository<Processamento> {

    List<Processamento> findTop3BySituacaoProcessamentoOrderByInicioDesc(ESituacaoProcessamento processamento);
}
