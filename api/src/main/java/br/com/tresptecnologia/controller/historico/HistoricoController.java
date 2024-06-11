package br.com.tresptecnologia.controller.historico;

import br.com.tresptecnologia.core.controller.BaseRsqlFindController;
import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.historico.Historico;
import br.com.tresptecnologia.model.historico.HistoricoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico")
@Tag(name = "Historico")
public class HistoricoController extends BaseRsqlFindController<Historico, HistoricoResponse> {
    protected HistoricoController(IBaseService<Historico> service, IBaseResponseMapper<Historico, HistoricoResponse> mapper) {
        super(service, mapper);
    }
}
