package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.exporter.ExporterType;
import br.com.tresptecnologia.core.exporter.IExporterService;
import br.com.tresptecnologia.core.exporter.model.ExporterRequest;
import br.com.tresptecnologia.core.exporter.exception.ExporterException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseExporterController<T extends BaseEntity> {

    IExporterService getExporterService();

    @PostMapping(value = "/export/{type}")
    @Operation(description = "Realiza a exportação dos dados de acordo com o tipo escolhido")
    default ResponseEntity<Resource> export(
            @Parameter(description = "Tipo do arquivo para qual será exportado. Valores disponíveis: `csv`, `excel` ou `pdf`", required = true)
            @PathVariable String type,
            @RequestBody ExporterRequest request) throws ExporterException {

        final var typeFactory = TypeFactory.defaultInstance();
        final var controllerType = typeFactory.constructType(this.getClass());
        final var entityType = controllerType.getSuperClass().getBindings().getBoundType(0);
        final Class<T> clazz = (Class<T>) entityType.getRawClass();

        return getExporterService().export(clazz, request, ExporterType.valueOf(type.toUpperCase()))
                .toResponseEntity();
    }
}
