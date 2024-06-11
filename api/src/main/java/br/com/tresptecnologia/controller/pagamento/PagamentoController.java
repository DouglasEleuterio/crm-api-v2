package br.com.tresptecnologia.controller.pagamento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoResponse;
import br.com.tresptecnologia.service.pagamento.IPagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
@Tag(name = "Pagamento")
public class PagamentoController extends BaseRsqlController<Pagamento, PagamentoRequest, PagamentoResponse> implements BaseActiveController<Pagamento>, BaseJsonSelectController<Pagamento> {

    protected PagamentoController(IPagamentoService service, IBaseMapper<Pagamento, PagamentoRequest, PagamentoResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public IPagamentoService  getService() {
        return (IPagamentoService) super.getService();
    }
}
