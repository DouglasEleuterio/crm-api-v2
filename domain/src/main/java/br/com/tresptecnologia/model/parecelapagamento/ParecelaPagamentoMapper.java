package br.com.tresptecnologia.model.parecelapagamento;

import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.pagamento.ParcelaPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParecelaPagamentoMapper extends IBaseMapper<ParcelaPagamento, ParcelaPagamentoRequest, ParcelaPagamentoResponse> {
}
