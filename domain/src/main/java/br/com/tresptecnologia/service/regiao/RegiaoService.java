package br.com.tresptecnologia.service.regiao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.procedimento.Regiao;
import br.com.tresptecnologia.repository.regiao.RegiaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RegiaoService implements IRegiaoService {

    private final RegiaoRepository regiaoRepository;

    public RegiaoService(RegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }

    @Override
    public Regiao findById(Long id) throws DomainException {
        return regiaoRepository.findById(id).orElseThrow(() -> new DomainException("Região não encontrada"));
    }
}
