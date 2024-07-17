package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.model.entity.BaseEntityRequest;
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
public class RegiaoProcedimentoAquisicaoRequest {

    private Long id;
    private String nome;
    private int quantidadeSessoes;
    private int intervaloEntreSessoes;
    private Double valor;
    private Boolean persistida;
    private BaseEntityRequest procedimento;
}
