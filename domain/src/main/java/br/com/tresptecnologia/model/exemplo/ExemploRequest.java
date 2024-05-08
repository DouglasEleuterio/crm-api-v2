package br.com.tresptecnologia.model.exemplo;

import br.com.tresptecnologia.model.entity.BaseEntityRequest;
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
public class ExemploRequest {

    private Long id;

    @RequiredSize(label = "exemplo.nome", min = 2, max = 255)
    private String nome;

    @RequiredSize(label = "exemplo.descricao", required = false, max = 255)
    private String descricao;

    private Boolean situacao;

    private BaseEntityRequest relacao;
}
