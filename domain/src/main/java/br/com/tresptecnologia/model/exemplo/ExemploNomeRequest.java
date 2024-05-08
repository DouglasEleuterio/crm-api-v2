package br.com.tresptecnologia.model.exemplo;

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
public class ExemploNomeRequest {

    @RequiredSize(label = "exemplo.nome", min = 2, max = 255)
    private String nome;

}
