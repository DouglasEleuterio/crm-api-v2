package br.com.tresptecnologia.controller.tabelavaloresmonofasicosnf;

import br.com.tresptecnologia.model.produto.ProdIncidenciaMonoResponse;
import br.com.tresptecnologia.service.tabelavaloresmonofasicosnf.TabelaValoresMonofasicosNFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tabela-valores-monofasico-nf")
@Tag(name = "Tabela Valores Monofasicos na NF")
public class TabelaValoresMonofasicosNFController {

    private final TabelaValoresMonofasicosNFService tabelaValoresMonofasicosNFService;

    @GetMapping(path = "/{cnpj}")
    @Operation(description = "Retorna lista de Produtos na NF que tem incidencia monofasica, dado CNPJ Destinatario")
    Page<ProdIncidenciaMonoResponse> findAllPorCNPJ(@PathVariable(value = "cnpj") String cnpj,
                                                             @SortDefault(sort = "det.infnf.ide.dhEmi", direction = Sort.Direction.DESC) Pageable pageable) {
        return tabelaValoresMonofasicosNFService.findAllProdutosComMonofasePorProduto(cnpj, pageable);
    }

    @GetMapping()
    @Operation(description = "Retorna lista de Produtos na NF que tem incidencia monofasica, todos Destinatarios")
    Page<ProdIncidenciaMonoResponse> findAllEntityProProduto(@SortDefault(sort = "det.infnf.ide.dhEmi", direction = Sort.Direction.DESC) Pageable pageable) {
        return tabelaValoresMonofasicosNFService.findAllProdutosComMonofasePorProduto(pageable);
    }
}
