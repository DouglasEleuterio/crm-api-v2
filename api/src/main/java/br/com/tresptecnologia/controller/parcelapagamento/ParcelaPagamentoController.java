package br.com.tresptecnologia.controller.parcelapagamento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.pagamento.ParcelaPagamento;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoRequest;
import br.com.tresptecnologia.model.parecelapagamento.ParcelaPagamentoResponse;
import br.com.tresptecnologia.service.parcelapagamento.ParcelaPagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parcela-pagamento")
@Tag(name = "Parcela Pagamento")
public class ParcelaPagamentoController extends BaseRsqlController<ParcelaPagamento, ParcelaPagamentoRequest, ParcelaPagamentoResponse>
        implements BaseActiveController<ParcelaPagamento>, BaseJsonSelectController<ParcelaPagamento> {

    protected ParcelaPagamentoController(ParcelaPagamentoService service, IBaseMapper<ParcelaPagamento, ParcelaPagamentoRequest, ParcelaPagamentoResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public ParcelaPagamentoService getService() {
        return (ParcelaPagamentoService) super.getService();
    }
}
