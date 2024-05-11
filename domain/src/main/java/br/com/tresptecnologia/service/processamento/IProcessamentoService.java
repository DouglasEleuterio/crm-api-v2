package br.com.tresptecnologia.service.processamento;

import br.com.tresptecnologia.entity.processamento.Processamento;
import br.com.tresptecnologia.enumeration.EOrigemProcessamento;

import java.util.List;

public interface IProcessamentoService {
    void alterarSituacaoProcessamentosPresos(List<Processamento> proceList);

    void iniciar(EOrigemProcessamento origemProcessamento);
}
