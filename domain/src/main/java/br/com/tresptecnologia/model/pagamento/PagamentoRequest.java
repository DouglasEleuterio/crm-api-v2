package br.com.tresptecnologia.model.pagamento;

import br.com.tresptecnologia.entity.pagamento.EFormaPagamento;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoRequest;
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
public class PagamentoRequest {

    private Long id;
    @Required(label = "pagamento.data")
    private LocalDateTime dataPagamento;
    @Required(label = "pagamento.valor")
    private Double valorPagamento;
    @Required(label = "pagamento.forma")
    private EFormaPagamento formaPagamento;
    @Required(label = "pagamento.quantidade-parcelas")
    private Integer quantidadeParcelas;
    @Required(label = "pagamento.taxa")
    private Double taxa;
    @RequiredList(label = "pagamento.parcela-pagamento")
    private Set<ParcelaPagamentoRequest> pagamentos;
}
