package br.com.tresptecnologia.controller.cidade;


import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.cliente.Cidade;
import br.com.tresptecnologia.service.cidade.ICidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
@Tag(name = "Cidade")
public class CidadeController implements BaseJsonSelectController<Cidade> {

    private final ICidadeService estadoService;

    public CidadeController(ICidadeService estadoService) {
        this.estadoService = estadoService;
    }

    @Override
    public IBaseFetchMapperService<Cidade> getService() {
        return estadoService;
    }
}
