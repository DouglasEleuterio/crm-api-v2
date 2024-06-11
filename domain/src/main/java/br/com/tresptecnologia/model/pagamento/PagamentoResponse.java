package br.com.tresptecnologia.model.pagamento;

import br.com.tresptecnologia.entity.pagamento.EFormaPagamento;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoResponse;
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
public class PagamentoResponse implements BaseResponse {

    private Long id;
    private LocalDateTime dataPagamento;
    private Double valorPagamento;
    private EFormaPagamento formaPagamento;
    private Integer quantidadeParcelas;
    private Double taxa;
    private Set<ParcelaPagamentoResponse> pagamentos;
}
