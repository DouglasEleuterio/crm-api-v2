package br.com.tresptecnologia.service.processamento;

import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.entity.processamento.Processamento;
import br.com.tresptecnologia.enumeration.EOrigemProcessamento;
import br.com.tresptecnologia.enumeration.ESituacaoFinalizacao;
import br.com.tresptecnologia.enumeration.ESituacaoProcessamento;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import br.com.tresptecnologia.repository.arquivo.ArquivoRepository;
import br.com.tresptecnologia.repository.processamento.ProcessamentoRepository;
import br.com.tresptecnologia.repository.xml.XmlRepository;
import br.com.tresptecnologia.service.ParseService;
import br.com.tresptecnologia.service.arquivo.IArquivoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessamentoService implements IProcessamentoService {

    private final ProcessamentoRepository repository;
    private final IArquivoService arquivoService;
    private final ParseService parseService;
    private final ArquivoRepository arquivoRepository;
    private final XmlRepository xmlRepository;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    @Override
    public void alterarSituacaoProcessamentosPresos(List<Processamento> proceList) {
            proceList.forEach(proc -> {
                proc.setSituacaoProcessamento(ESituacaoProcessamento.FINALIZADO);
                proc.setSituacaoFinalizacao(ESituacaoFinalizacao.INATIVIDADE);
            });
            repository.saveAllAndFlush(proceList);
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
        repository.saveAndFlush(proc);

        processar(arquivos, proc);
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    protected void processar(List<Arquivo> arquivos, Processamento proc) {
        proc.setQuantidadeErro(0L);
        proc.setQuantidadeProcessada(0L);        for (Arquivo arquivo : arquivos) {
            try {

                var xml = parseService.convertArquivoToXml(arquivo);
                arquivo.setSituacaoArquivo(EnumSituacaoArquivo.PROCESSADO);

                xml.setArquivo(arquivo);

                proc.setUltimoProcessamento(LocalDateTime.now());

                xmlRepository.saveAndFlush(xml);
                arquivoRepository.saveAndFlush(arquivo);
                repository.saveAndFlush(proc);
            } catch (Exception e) {

                proc.setQuantidadeErro(proc.getQuantidadeErro() + 1);

                arquivo.setErro(Strings.isEmpty(e.getMessage()) ? "erro desconhecido" : e.getMessage()  );
                arquivo.setSituacaoArquivo(EnumSituacaoArquivo.ERRO_NO_PROCESSAMENTO);
                arquivoRepository.saveAndFlush(arquivo);
            }
        }
        proc.setSituacaoFinalizacao(ESituacaoFinalizacao.SUCESSO);
        proc.setFim(LocalDateTime.now());
        proc.setSituacaoProcessamento(ESituacaoProcessamento.FINALIZADO);

        repository.saveAndFlush(proc);
    }
}
