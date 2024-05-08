package br.com.tresptecnologia.controller.jasper;

import br.com.tresptecnologia.core.report.ReportType;
import br.com.tresptecnologia.core.report.exception.ReportException;
import br.com.tresptecnologia.service.exemplo.report.IExemploReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exemplo de implementação de geração de relatório.
 * Este controle serve apenas para exemplo e deve ser removido quando o projeto for entregue
 */
@RestController
@RequestMapping("/jasper-teste")
@Tag(name = "Teste de Geração de Relatório")
public class JasperController {

    private final IExemploReportService exemploReportService;

    public JasperController(final IExemploReportService exemploReportService) {
        this.exemploReportService = exemploReportService;
    }

    @GetMapping(value = "/{type}")
    @Operation(description = "Realiza a geração do relatório de exemplo")
    public ResponseEntity<Resource> relatorioExcesso(@PathVariable String type)
            throws ReportException {
        return exemploReportService.relatorioExemplo(ReportType.valueOf(type.toUpperCase())).toResponseEntity();
    }

}
