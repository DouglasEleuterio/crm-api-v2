package br.com.tresptecnologia.model.pedido;

import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.entity.BaseResponse;
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
public class PedidoResponse implements BaseResponse {

    private ClienteRequest cliente;
    private Double valorTotal;
    private Double desconto;
    private Double valorTotalItens;
}
