package br.com.tresptecnologia.model.aquisicaoprocedimento;

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
public class AquisicaoProcedimentoRequest {

    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;
}
