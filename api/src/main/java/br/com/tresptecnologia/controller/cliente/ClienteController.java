package br.com.tresptecnologia.controller.cliente;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.controller.swagger.annotation.SwaggerGenericResponseType;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.cliente.ClienteResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.service.cliente.IClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
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
