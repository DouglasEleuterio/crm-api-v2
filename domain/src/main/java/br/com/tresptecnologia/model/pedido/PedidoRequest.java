package br.com.tresptecnologia.model.pedido;

import br.com.tresptecnologia.model.base.BaseMQEvent;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.itemdevenda.ItemDePedidoRequest;
import br.com.tresptecnologia.model.pagamento.Pagamento;
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
public class PedidoRequest extends BaseMQEvent {

    private ClienteRequest cliente;
    private Set<ItemDePedidoRequest> itens;
    private Set<Pagamento> pagamentos;
    @Required(label = "pedido.valor-total")
    private Double valorTotal;
    @Required(label = "pedido.desconto")
    private Double desconto;
    @Required(label = "pedido.valor-total-itens")
    private Double valorTotalItens;
}
