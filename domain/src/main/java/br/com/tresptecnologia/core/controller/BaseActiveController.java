package br.com.tresptecnologia.core.controller;

import br.com.tresptecnologia.model.entity.BaseEntityActiveRequest;
import br.com.tresptecnologia.core.entity.BaseActiveEntity;
import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.exception.DomainException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseActiveController<T extends BaseActiveEntity> {

    IBaseActiveService<T> getService();

    @PatchMapping(value = "/active/{id}")
    @Operation(description = "Altera a situação do registro Ativo/Inativo")
    default ResponseEntity<Void> active(@PathVariable Long id, @Valid @RequestBody BaseEntityActiveRequest activeRequest) throws DomainException {
        getService().active(id, activeRequest.getAtivo());
        return ResponseEntity.ok().build();
    }
}
