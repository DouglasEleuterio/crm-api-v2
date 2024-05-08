package br.com.tresptecnologia.controller.exemplo;

import br.com.tresptecnologia.core.controller.BaseJsonSelectController;
import br.com.tresptecnologia.entity.benchmark.ExemploRoot;
import br.com.tresptecnologia.service.exemplo.IExemploRootService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exemplo de implementação de um controller utilizando as classes abstratas
 * Este controle serve apenas para exemplo e deve ser removido quando o projeto for entregue
 */
@RestController
@RequestMapping("/roots")
@Tag(name = "Exemplo Root")
public class ExemploRootController implements BaseJsonSelectController<ExemploRoot> {

    final IExemploRootService service;

    protected ExemploRootController(final IExemploRootService service) {
        this.service = service;
    }

    @Override
    public IExemploRootService getService() {
        return service;
    }

}
