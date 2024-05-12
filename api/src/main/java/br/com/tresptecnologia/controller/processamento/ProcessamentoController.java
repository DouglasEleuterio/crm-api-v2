package br.com.tresptecnologia.controller.processamento;

import br.com.tresptecnologia.job.ProcessamentoJob;
import br.com.tresptecnologia.service.processamento.ProcessamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processamento")
@Tag(name = "Processamento")
@RequiredArgsConstructor
public class ProcessamentoController {

    private final ProcessamentoJob processamentoJob;
    private final ProcessamentoService processamentoService;

    @GetMapping
    public ResponseEntity<Boolean> processar() {
        if(processamentoService.isEmProcessamento())
            return ResponseEntity.ok(false);

        processamentoJob.iniciarProcessamentoXmlManual();
        return ResponseEntity.ok(true);
    }
}
