package br.com.tresptecnologia.controller.aquisicao;


import br.com.tresptecnologia.core.controller.BaseActiveController;
import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.controller.BaseRsqlController;
import br.com.tresptecnologia.core.mapper.IBaseMapper;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.model.aquisicao.AquisicaoRequest;
import br.com.tresptecnologia.model.aquisicao.AquisicaoResponse;
import br.com.tresptecnologia.service.aquisicao.IAquisicaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aquisicao")
@Tag(name = "Aquisicao")
public class AquisicaoController extends BaseRsqlController<Aquisicao, AquisicaoRequest, AquisicaoResponse> implements BaseActiveController<Aquisicao>, BaseJsonSelectController<Aquisicao> {
    protected AquisicaoController(IAquisicaoService service, IBaseMapper<Aquisicao, AquisicaoRequest, AquisicaoResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public IAquisicaoService getService() {
        return (IAquisicaoService) super.getService();
    }
}
