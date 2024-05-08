package br.com.tresptecnologia.model.pagamento;

import br.com.tresptecnologia.model.formapagamento.FormaDePagamento;
import br.com.tresptecnologia.model.parcela.Parcela;
import br.com.tresptecnologia.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {
    @Required
    private FormaDePagamento formaDePagamento;
    @Required
    private int quantidadeParcelas;
    @Required
    private Set<Parcela> parcelas;
    @Required
    private Double valor;
}
