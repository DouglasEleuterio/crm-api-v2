package br.com.tresptecnologia.model.pedido;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.ItemDePedido;
import br.com.tresptecnologia.entity.Pedido;
import br.com.tresptecnologia.entity.Produto;
import br.com.tresptecnologia.model.itemdevenda.ItemDePedidoRequest;
import br.com.tresptecnologia.model.produto.ProdutoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper extends IBaseMapper<Pedido, PedidoRequest, PedidoResponse> {

    default ItemDePedido itemDePedidoRequestToItemDePedido(ItemDePedidoRequest itemDePedidoRequest){
        if ( itemDePedidoRequest == null ) {
            return null;
        }

        ItemDePedido itemDePedido = new ItemDePedido();

        if ( itemDePedidoRequest.getQuantidade() != null ) {
            itemDePedido.setQuantidade( itemDePedidoRequest.getQuantidade().longValue() );
        }
        itemDePedido.setValorUnitario( itemDePedidoRequest.getProduto().getPreco() );
        itemDePedido.setProduto( produtoRequestToProduto( itemDePedidoRequest.getProduto() ) );

        return itemDePedido;
    }

    default Produto produtoRequestToProduto(ProdutoRequest produtoRequest) {
        if ( produtoRequest == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setId( produtoRequest.getId() );
        produto.setNome( produtoRequest.getNome() );
        produto.setPreco( produtoRequest.getPreco() );

        return produto;
    }
}
