package br.com.tresptecnologia.service.processamento;

import br.com.tresptecnologia.core.config.JobProperties;
import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.entity.processamento.Processamento;
import br.com.tresptecnologia.enumeration.EOrigemProcessamento;
import br.com.tresptecnologia.enumeration.ESituacaoFinalizacao;
import br.com.tresptecnologia.enumeration.ESituacaoProcessamento;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import br.com.tresptecnologia.repository.processamento.ProcessamentoRepository;
import br.com.tresptecnologia.service.ParseService;
import br.com.tresptecnologia.service.arquivo.IArquivoService;
import br.com.tresptecnologia.service.auxiliar.AuxiliarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProcessamentoService implements IProcessamentoService {

    private final IArquivoService arquivoService;
    private final ParseService parseService;
    private final AuxiliarService auxiliarService;
    private final ProcessamentoRepository processamentoRepository;
    private final JobProperties properties;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Override
    public void alterarSituacaoProcessamentosPresos(List<Processamento> proceList) {
        proceList.forEach(proc -> {
            proc.setSituacaoProcessamento(ESituacaoProcessamento.FINALIZADO);
            proc.setSituacaoFinalizacao(ESituacaoFinalizacao.INATIVIDADE);
        });
        auxiliarService.saveProcessamento(proceList);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Override
    public void iniciar(EOrigemProcessamento origemProcessamento) {
        var arquivos = arquivoService.getAllNaoProcessado();

        var proc = Processamento.builder()
                .inicio(LocalDateTime.now())
                .situacaoProcessamento(ESituacaoProcessamento.PROCESSANDO)
                .origemProcessamento(origemProcessamento)
                .quantidadeParaProcessar(arquivos.isEmpty() ? 0L : (long) arquivos.size())
                .build();
        auxiliarService.saveProcessamento(proc);

        processar(arquivos, proc);
    }

    @Override
    public Boolean isEmProcessamento() {
        var limiteProcesamento = Objects.isNull(properties.getMilisegundosLimiteProcessamento()) ? 300000 : properties.getMilisegundosLimiteProcessamento();
        var procList = processamentoRepository.findTop3BySituacaoProcessamentoOrderByInicioDesc(ESituacaoProcessamento.PROCESSANDO);

        if (procList.isEmpty())
            return false;

        return procList
                .stream()
                .anyMatch(p -> Objects.isNull(p.getUltimoProcessamento()) || p.getUltimoProcessamento().plus(Duration.ofMillis(limiteProcesamento))
                        .isBefore(LocalDateTime.now()));

    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    protected void processar(List<Arquivo> arquivos, Processamento proc) {
        proc.setQuantidadeErro(0L);
        proc.setQuantidadeProcessada(0L);
        for (Arquivo arquivo : arquivos) {
            try {

                var xml = parseService.convertArquivoToXml(arquivo);
                auxiliarService.saveXml(xml);

                arquivo.setSituacaoArquivo(EnumSituacaoArquivo.PROCESSADO);
                var arqSaved = auxiliarService.saveArquivo(arquivo);

                xml.setArquivo(arqSaved);
                auxiliarService.saveXml(xml);

                proc.setUltimoProcessamento(LocalDateTime.now());
                proc.setQuantidadeProcessada(proc.getQuantidadeProcessada() + 1);

                auxiliarService.saveProcessamento(proc);
            } catch (Exception e) {

                proc.setQuantidadeErro(proc.getQuantidadeErro() + 1);

                arquivo.setErro(Strings.isEmpty(e.getMessage()) ? "erro desconhecido" : e.getMessage());
                arquivo.setSituacaoArquivo(EnumSituacaoArquivo.ERRO_NO_PROCESSAMENTO);
                auxiliarService.saveArquivo(arquivo);
            }
        }
        proc.setSituacaoFinalizacao(ESituacaoFinalizacao.SUCESSO);
        proc.setFim(LocalDateTime.now());
        proc.setSituacaoProcessamento(ESituacaoProcessamento.FINALIZADO);

        auxiliarService.saveProcessamento(proc);
    }
}
