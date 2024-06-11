package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

import br.com.tresptecnologia.model.aquisicaoprocedimento.AquisicaoProcedimentoRequest;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoRequest {

    private Long id;
    private LocalDateTime dataAquisicao;
    private Double valorAquisicao;
    private Double valorDesconto;
    private ClienteRequest cliente;
    private AquisicaoProcedimentoRequest aquisicaoProcedimento;
    private Set<PagamentoRequest> pagamentos;
}
