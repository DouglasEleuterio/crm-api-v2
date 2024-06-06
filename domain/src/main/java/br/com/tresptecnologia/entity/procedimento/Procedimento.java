package br.com.tresptecnologia.entity.procedimento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Procedimento {
    private String nome;
    private Double valor;
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;

}
