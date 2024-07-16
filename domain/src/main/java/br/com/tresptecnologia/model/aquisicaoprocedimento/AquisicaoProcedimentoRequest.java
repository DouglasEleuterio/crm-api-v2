package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredType;
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
public class AquisicaoProcedimentoRequest {

    @Required(type = RequiredType.UPDATE)
    private Long id;
    private String nome;
    private Long procedimentoOrigemId;
    private Set<RegiaoProcedimentoAquisicaoRequest> regioes;

    public Double getValorRegioes() {
        return getRegioes().stream().reduce(0.0, (partialValue, regiao) -> partialValue + regiao.getValor(), Double::sum);
    }
}
