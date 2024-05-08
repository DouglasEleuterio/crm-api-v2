package br.com.tresptecnologia.model.exemplo.relacao;

import br.com.tresptecnologia.model.entity.BaseResponse;
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
public class ExemploRelacaoResponse implements BaseResponse {

    private Long id;
    private String nome;

    public ExemploRelacaoResponse(String nome) {
        this.nome = nome;
    }
}
