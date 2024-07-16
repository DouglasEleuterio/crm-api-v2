package br.com.tresptecnologia.model.pagamento;

import br.com.tresptecnologia.entity.pagamento.EFormaPagamento;
import br.com.tresptecnologia.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @Required(label = "pagamento.taxa")
    private Double taxa;
}
