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

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TabelaValoresMonofasicosNFService {

    private final ProdRepository prodRepository;
    private final ProdMapper prodMapper;

    @Transactional(readOnly = true)
    public Page<ProdIncidenciaMonoResponse> findAllProdutosComMonofasePorProduto(Pageable pageable, String cnpjDestinatario, LocalDate dataEmissaoInicio, LocalDate dataEmissaoFim, String search) {
        if (Objects.nonNull(search)) {
            if (search.contains("dataEmissaoInicio>=")) {
                var str = search.split("dataEmissaoInicio>=")[1];
                dataEmissaoInicio = LocalDate.parse(str.substring(0, 10));
            }
            if (search.contains("dataEmissaoFim<=")) {
                var str = search.split("dataEmissaoFim<=")[1];
                dataEmissaoFim = LocalDate.parse(str.substring(0, 10));
            }
            if (search.contains("cnpj=")) {
                var str = search.split("cnpj==")[1];
                cnpjDestinatario = "%".concat(str).concat("%");
            }
        }
        return prodRepository.getAllIncidenciaMonofasica(EnumSituacao.ATIVO, cnpjDestinatario, pageable, dataEmissaoInicio, dataEmissaoFim).map(prodMapper::toResponse);
    }

}

//2024-03-21T15:22:00-03:00