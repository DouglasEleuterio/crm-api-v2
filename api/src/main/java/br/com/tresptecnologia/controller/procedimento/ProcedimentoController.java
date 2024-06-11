package br.com.tresptecnologia.controller.procedimento;

import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import br.com.tresptecnologia.model.procedimento.ProcedimentoRequest;
import br.com.tresptecnologia.model.procedimento.ProcedimentoResponse;
import br.com.tresptecnologia.service.procedimento.IProcedimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/procedimento")
@Tag(name = "Procedimento")
public class ProcedimentoController extends BaseRsqlController<Procedimento, ProcedimentoRequest, ProcedimentoResponse>
        implements BaseActiveController<Procedimento>, BaseJsonSelectController<Procedimento> {

    protected ProcedimentoController(IProcedimentoService service, IBaseMapper<Procedimento, ProcedimentoRequest, ProcedimentoResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public IProcedimentoService getService() {
        return (IProcedimentoService) super.getService();
    }
}
