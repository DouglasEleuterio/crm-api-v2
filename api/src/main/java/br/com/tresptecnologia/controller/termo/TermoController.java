package br.com.tresptecnologia.controller.termo;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.entity.termo.Termo;
import br.com.tresptecnologia.model.termo.TermoMapper;
import br.com.tresptecnologia.model.termo.TermoRequest;
import br.com.tresptecnologia.model.termo.TermoResponse;
import br.com.tresptecnologia.service.termo.TermoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/termo")
@Tag(name = "Termo")
public class TermoController extends BaseRsqlController<Termo, TermoRequest, TermoResponse>
        implements BaseActiveController<Termo>, BaseJsonSelectController<Termo> {

    private final TermoService service;

    protected TermoController(TermoService service,
                              TermoMapper mapper) {
        super(service, mapper);
        this.service = service;
    }

    @Override
    public TermoService getService() {
        return service;
    }
}
