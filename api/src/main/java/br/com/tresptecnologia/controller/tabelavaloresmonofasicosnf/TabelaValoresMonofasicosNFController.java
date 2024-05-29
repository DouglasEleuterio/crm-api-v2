package br.com.tresptecnologia.controller.tabelavaloresmonofasicosnf;

import br.com.tresptecnologia.model.tabelavaloresmonofasicosnf.TabelaValoresMonofasicosNF;
import br.com.tresptecnologia.service.tabelavaloresmonofasicosnf.TabelaValoresMonofasicosNFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tabela-valores-monofasico-nf")
@Tag(name = "Tabela Valores Monofasicos na NF")
public class TabelaValoresMonofasicosNFController {

    private final TabelaValoresMonofasicosNFService tabelaValoresMonofasicosNFService;

    @GetMapping
    @Operation(description = "Retorna lista de Produtos na NF que tem incidencia monofasica")
    List<TabelaValoresMonofasicosNF> findAllProdutosComMonosfasico() {
        return tabelaValoresMonofasicosNFService.findAllProdutosComMonosfasico();
    }
}
