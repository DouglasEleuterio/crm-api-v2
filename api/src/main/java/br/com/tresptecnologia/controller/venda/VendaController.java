package br.com.tresptecnologia.controller.venda;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseExporterController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.exporter.IExporterService;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.Pedido;
import br.com.tresptecnologia.model.pedido.PedidoMapper;
import br.com.tresptecnologia.model.pedido.PedidoRequest;
import br.com.tresptecnologia.model.pedido.PedidoResponse;
import br.com.tresptecnologia.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController extends BaseRsqlController<Pedido, PedidoRequest, PedidoResponse>
        implements BaseActiveController<Pedido>, BaseExporterController<Pedido>,
        BaseJsonSelectController<Pedido> {

    private final IExporterService exporterService;

    public VendaController(IExporterService exporterService,
                           IBaseService<Pedido> pedidoService,
                           PedidoMapper pedidoMapper) {
        super(pedidoService, pedidoMapper);
        this.exporterService = exporterService;
    }

    @Override
    public PedidoService getService() {
        return (PedidoService) super.getService();
    }

    @Override
    public PedidoMapper getMapper() {
        return (PedidoMapper) super.getMapper();
    }

    @Override
    public IExporterService getExporterService() {
        return exporterService;
    }
}
