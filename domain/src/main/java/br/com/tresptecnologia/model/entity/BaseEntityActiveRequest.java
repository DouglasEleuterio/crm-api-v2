package br.com.tresptecnologia.model.entity;

import br.com.tresptecnologia.shared.validation.RequiredSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityActiveRequest {

    @RequiredSize(label = "shared.ativo")
    private Boolean ativo;

}
