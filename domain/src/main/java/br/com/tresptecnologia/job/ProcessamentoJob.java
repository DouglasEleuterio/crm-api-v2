package br.com.tresptecnologia.job;

import br.com.tresptecnologia.core.config.JobProperties;
import br.com.tresptecnologia.enumeration.EOrigemProcessamento;
import br.com.tresptecnologia.enumeration.ESituacaoProcessamento;
import br.com.tresptecnologia.repository.processamento.ProcessamentoRepository;
import br.com.tresptecnologia.service.processamento.IProcessamentoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
@Slf4j
public class ProcessamentoJob {

    private final ProcessamentoRepository repository;
    private final JobProperties properties;
    private final IProcessamentoService processamentoService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void iniciarProcessamentoXml() {

        var limiteProcesamento = Objects.isNull(properties.getMilisegundosLimiteProcessamento()) ? 120000 : properties.getMilisegundosLimiteProcessamento();

        var procList = repository.findTop3BySituacaoProcessamentoOrderByInicioDesc(ESituacaoProcessamento.PROCESSANDO);
        //Não existe processamento sendo executado
        if (procList.isEmpty()) {
            log.info("Nao existem processamentos em execução, vou executar");
            processamentoService.iniciarProcessamentoArquivos(EOrigemProcessamento.JOB);

        } else {
            log.info("Existem processamentos em execução, vou checar seu processamento");
            var isExisteProcessamentoPreso =
                    procList
                            .stream()
                            .anyMatch(p -> Objects.isNull(p.getUltimoProcessamento()) || p.getUltimoProcessamento().plus(Duration.ofMillis(limiteProcesamento))
                                    .isBefore(LocalDateTime.now()));

            //Existe procecssamento sendo executado e último processamento inferior ao tempo limite definido
            //Ex:
            // Ultimo processamento = 10:00:00
            // Agora                = 10:03:00
            // Limite               = 10:05:00
            //Não processar
            if (!isExisteProcessamentoPreso) {
                log.info("Não existe processamento preso, não vou processar pois o Job já está trabalhando.");
                processamentoService.iniciarProcessamentoArquivos(EOrigemProcessamento.JOB);
            } else {
                //Existe processamento preso
                log.info("Existem processamento(s) preso(s) vou alterar a situação dele(s) e processar os arquivos");
                processamentoService.alterarSituacaoProcessamentosPresos(procList);
                processamentoService.iniciarProcessamentoArquivos(EOrigemProcessamento.JOB);
            }
        }
    }

    @Async
    public void iniciarProcessamentoXmlManual() {
        processamentoService.iniciarProcessamentoArquivos(EOrigemProcessamento.USUARIO);
    }
}
