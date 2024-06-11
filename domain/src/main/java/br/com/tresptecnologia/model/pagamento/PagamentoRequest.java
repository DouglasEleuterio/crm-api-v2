package br.com.tresptecnologia.model.pagamento;

import br.com.tresptecnologia.entity.pagamento.EFormaPagamento;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoRequest;
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
    private LocalDateTime dataPagamento;
    private Double valorPagamento;
    private EFormaPagamento formaPagamento;
    private Integer quantidadeParcelas;
    private Double taxa;
    private Set<ParcelaPagamentoRequest> pagamentos;
}
