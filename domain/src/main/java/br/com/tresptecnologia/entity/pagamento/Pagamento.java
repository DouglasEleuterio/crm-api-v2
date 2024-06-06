package br.com.tresptecnologia.entity.pagamento;

import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Pagamento {
    private LocalDateTime dataPagamento;
    private Double valorPagamento;
    private EFormaPagamento formaPagamento;
    private Integer quantidadeParcelas;
    private Double taxa;
    private Aquisicao aquisicao;
}
