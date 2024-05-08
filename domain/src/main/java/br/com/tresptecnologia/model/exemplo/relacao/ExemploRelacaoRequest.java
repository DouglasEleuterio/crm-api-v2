package br.com.tresptecnologia.model.exemplo.relacao;

import br.com.tresptecnologia.shared.validation.Required;
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
public class ExemploRelacaoRequest {

    @Required(label = "exemploRelacao.nome")
    private String nome;

}
