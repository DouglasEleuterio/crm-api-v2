package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.model.aquisicaoprocedimento.AquisicaoProcedimentoRequest;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoRequest {

    private Long id;
    @Required(label = "aquisicao.data-aquisicao")
    private LocalDateTime dataAquisicao;
    @Required(label = "aquisicao.valor-aquisicao")
    private Double valorAquisicao;
    @Required(label = "aquisicao.valor-desconto")
    private Double valorDesconto;
    @Required(label = "aquisicao.cliente")
    private ClienteRequest cliente;
    @RequiredList(label = "aquisicao.pagamento", alias = "pagamento(s)")
    private Set<PagamentoRequest> pagamentos;
    @Required(label = "aquisicao.procedimento")
    private Set<AquisicaoProcedimentoRequest> procedimentos;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
