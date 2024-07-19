package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoProcedimentoResponse implements BaseResponse {

    private Long id;
    private String nome;
    private Set<RegiaoProcedimentoAquisicaoResponse> regioes;
}
