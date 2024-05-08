package br.com.tresptecnologia.model.itemdevenda;

import br.com.tresptecnologia.model.produto.ProdutoRequest;
import br.com.tresptecnologia.shared.validation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDePedidoRequest {
    @Required
    private ProdutoRequest produto;
    @Required
    private Integer quantidade;
    private Double valorUnitario;
}
