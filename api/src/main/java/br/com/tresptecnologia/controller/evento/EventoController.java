package br.com.tresptecnologia.controller.evento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.evento.Evento;
import br.com.tresptecnologia.model.evento.EventoRequest;
import br.com.tresptecnologia.model.evento.EventoResponse;
import br.com.tresptecnologia.service.evento.IEventoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evento")
@Tag(name = "Evento")
public class EventoController extends BaseRsqlController<Evento, EventoRequest, EventoResponse>
        implements BaseActiveController<Evento>, BaseJsonSelectController<Evento> {

    protected EventoController(final IEventoService service,
                               final IBaseMapper<Evento, EventoRequest, EventoResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public IEventoService getService() {
        return (IEventoService) super.getService();
    }
}

