package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.enumeration.EProcedimento;
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
public class ProcedimentoAquisicaoRequest {

    private Long id;
    private EProcedimento nome;
    private String regioao;
    private int quantidadeSessoes;
    private int intervaloEntreSessoes;
    private Double valor;
}
