package br.com.tresptecnologia.model.parecelapagamento;

import br.com.tresptecnologia.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParcelaPagamentoRequest {

    private Long id;
    @Required(label = "parcela.data-credito")
    private LocalDate dataCredito;
    @Required(label = "parcela.valor-credito")
    private Double valorCredito;
    @Required(label = "parcela.valor-taxa")
    private Double valorTaxa;
    private Boolean isRecebido;
    @Required(label = "parcela.numero")
    private Integer numeroParcela;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
