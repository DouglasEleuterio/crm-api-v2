package br.com.tresptecnologia.entity.pagamento;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ParcelaPagamento {
    private LocalDate dataCredito;
    private Double valorCredito;
    private Double valorTaxa;
    private Boolean isRecebido;
    private Integer numeroParcela;
}