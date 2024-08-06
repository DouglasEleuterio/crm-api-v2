package br.com.tresptecnologia.controller.profissional;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.profissional.Profissional;
import br.com.tresptecnologia.model.profissional.ProfissionalRequest;
import br.com.tresptecnologia.model.profissional.ProfissionalResponse;
import br.com.tresptecnologia.service.profissional.ProfissionalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissional")
@Tag(name = "Profissional")
public class ProfissionalController extends BaseRsqlController<Profissional, ProfissionalRequest, ProfissionalResponse>
        implements BaseActiveController<Profissional>, BaseJsonSelectController<Profissional> {

    private final ProfissionalService service;

    protected ProfissionalController(ProfissionalService service, IBaseMapper<Profissional, ProfissionalRequest, ProfissionalResponse> mapper) {
        super(service, mapper);
        this.service = service;
    }

    @Override
    public ProfissionalService getService() {
        return service;
    }
}
