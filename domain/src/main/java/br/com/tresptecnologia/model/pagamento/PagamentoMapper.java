package br.com.tresptecnologia.model.pagamento;


import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagamentoMapper extends IBaseMapper<Pagamento, PagamentoRequest, PagamentoResponse> {
}
