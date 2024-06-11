package br.com.tresptecnologia.controller.auditoria;

import br.com.tresptecnologia.core.controller.BaseRsqlFindController;
import br.com.tresptecnologia.core.mapper.IBaseResponseMapper;
import br.com.tresptecnologia.core.service.IBaseService;
import br.com.tresptecnologia.entity.historico.Auditoria;
import br.com.tresptecnologia.model.auditoria.AuditoriaResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auditoria")
@Tag(name = "Auditoria")
public class AuditoriaController extends BaseRsqlFindController<Auditoria, AuditoriaResponse> {

    protected AuditoriaController(IBaseService<Auditoria> service, IBaseResponseMapper<Auditoria, AuditoriaResponse> mapper) {
        super(service, mapper);
    }
}
