package br.com.tresptecnologia.model.parecelapagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelaPagamentoRequest {

    private Long id;
    private LocalDate dataCredito;
    private Double valorCredito;
    private Double valorTaxa;
    private Boolean isRecebido;
    private Integer numeroParcela;
}
