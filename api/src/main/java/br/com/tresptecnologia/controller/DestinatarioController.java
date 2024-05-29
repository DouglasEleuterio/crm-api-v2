package br.com.tresptecnologia.controller;

import br.com.tresptecnologia.service.DestinatarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/destinatario")
@Tag(name = "Destinatarios")
public class DestinatarioController {

    private final DestinatarioService destinatarioService;

    @GetMapping
    @Operation(description = "Retorna lista de Produtos na NF que tem incidencia monofasica")
    List<String> findAllDestinatarios() {
        return destinatarioService.getAll();
    }
}
