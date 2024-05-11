package br.com.tresptecnologia.service.arquivo;

import br.com.tresptecnologia.entity.Arquivo;
import br.com.tresptecnologia.enumeration.EnumSituacaoArquivo;
import br.com.tresptecnologia.repository.arquivo.ArquivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArquivoService implements IArquivoService {

    private final ArquivoRepository arquivoRepository;

    @Override
    public List<Arquivo> getAllNaoProcessado() {
        return arquivoRepository.findBySituacaoArquivo(EnumSituacaoArquivo.PENDENTE);
    }
}
