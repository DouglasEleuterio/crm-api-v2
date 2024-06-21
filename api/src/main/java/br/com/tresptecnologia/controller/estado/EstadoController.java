package br.com.tresptecnologia.controller.estado;


import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.cliente.Estado;
import br.com.tresptecnologia.service.estado.IEstadoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
@Tag(name = "Estado")
public class EstadoController implements BaseJsonSelectController<Estado> {

    private final IEstadoService estadoService;

    public EstadoController(IEstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @Override
    public IBaseFetchMapperService<Estado> getService() {
        return estadoService;
    }
}
