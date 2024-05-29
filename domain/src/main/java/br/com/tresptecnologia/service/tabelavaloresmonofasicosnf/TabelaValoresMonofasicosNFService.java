package br.com.tresptecnologia.service.tabelavaloresmonofasicosnf;

import br.com.tresptecnologia.enumeration.EnumSituacao;
import br.com.tresptecnologia.model.produto.ProdIncidenciaMonoResponse;
import br.com.tresptecnologia.model.produto.ProdMapper;
import br.com.tresptecnologia.repository.produto.ProdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TabelaValoresMonofasicosNFService {

    private final ProdRepository prodRepository;
    private final ProdMapper prodMapper;

    @Transactional(readOnly = true)
    public Page<ProdIncidenciaMonoResponse> findAllProdutosComMonofasePorProduto(String cnpjDestinatario, Pageable pageable) {

        return prodRepository.getAllIncidenciaMonofasica(EnumSituacao.ATIVO, cnpjDestinatario, pageable).map(prodMapper::toResponse);
    }
}
