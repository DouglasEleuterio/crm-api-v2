package br.com.tresptecnologia.controller.cliente;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.cliente.ClienteResponse;
import br.com.tresptecnologia.service.cliente.IClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/cliente")
@Tag(name = "Cliente")
public class ClienteController extends BaseRsqlController<Cliente, ClienteRequest, ClienteResponse>
        implements BaseActiveController<Cliente>, BaseJsonSelectController<Cliente> {


    protected ClienteController(IClienteService service, IBaseMapper<Cliente, ClienteRequest, ClienteResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public IClienteService getService() {
        return (IClienteService) super.getService();
    }
}
