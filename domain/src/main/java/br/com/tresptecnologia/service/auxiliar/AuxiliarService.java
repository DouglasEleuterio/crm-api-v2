package br.com.tresptecnologia.service.auxiliar;

import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.entity.notafiscal.XML;
import br.com.tresptecnologia.entity.processamento.Processamento;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import br.com.tresptecnologia.repository.arquivo.ArquivoRepository;
import br.com.tresptecnologia.repository.processamento.ProcessamentoRepository;
import br.com.tresptecnologia.repository.xml.XmlRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuxiliarService {

    private final XmlRepository xmlRepository;
    private final ArquivoRepository arquivoRepository;
    private final ProcessamentoRepository processamentoRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveXml(XML xml) {
        xmlRepository.saveAndFlush(xml);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Arquivo saveArquivo(Arquivo arquivo) {
        return arquivoRepository.saveAndFlush(arquivo);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveProcessamento(Processamento proc) {
        processamentoRepository.saveAndFlush(proc);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveProcessamento(List<Processamento> procList) {
        processamentoRepository.saveAllAndFlush(procList);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public boolean isArquivoJaProcessado(Arquivo arquivo) {
        return arquivoRepository.findById(arquivo.getId()).orElseThrow().getSituacaoArquivo().equals(EnumSituacaoArquivo.PROCESSADO);
    }
}
