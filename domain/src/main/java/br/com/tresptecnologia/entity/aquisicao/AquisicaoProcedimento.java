package br.com.tresptecnologia.entity.aquisicao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AquisicaoProcedimento {
    private String nome;
    private Double valor;
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;
}
