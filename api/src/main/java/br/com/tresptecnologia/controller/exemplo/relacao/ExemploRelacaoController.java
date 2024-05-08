package br.com.tresptecnologia.controller.exemplo.relacao;

import br.com.tresptecnologia.core.controller.BaseController;
import br.com.tresptecnologia.entity.ExemploRelacao;
import br.com.tresptecnologia.model.exemplo.relacao.ExemploRelacaoRequest;
import br.com.tresptecnologia.model.exemplo.relacao.ExemploRelacaoResponse;
import br.com.tresptecnologia.model.exemplo.relacao.IExemploRelacaoMapper;
import br.com.tresptecnologia.service.exemplo.relacao.IExemploRelacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo-relacoes")
@Tag(name = "Exemplos Relações")
public class ExemploRelacaoController extends BaseController<ExemploRelacao, ExemploRelacaoRequest, ExemploRelacaoResponse> {

    protected ExemploRelacaoController(final IExemploRelacaoService service, final IExemploRelacaoMapper mapper) {
        super(service, mapper);
    }

}
