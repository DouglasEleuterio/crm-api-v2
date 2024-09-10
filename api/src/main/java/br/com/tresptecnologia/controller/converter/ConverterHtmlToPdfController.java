package br.com.tresptecnologia.controller.converter;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.service.converter.IOpenHtmlToPdfConverterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
@Tag(name = "Conversor Html para PDF")
public class ConverterHtmlToPdfController {

    private final IOpenHtmlToPdfConverterService converterService;

    public ConverterHtmlToPdfController(IOpenHtmlToPdfConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestParam(name = "idDocumento") String idDocumento) throws DomainException {
        byte[] pdfBytes = converterService.generatePdfFromHtml(idDocumento);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=generated.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
