package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.model.aquisicao.AquisicaoClienteResponse;
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
public class AquisicaoProcedimentoResponse implements BaseResponse {

    private Long id;
    private String nome;
    private Long procedimentoOrigemId;
    private int intervaloEntreSessoes;
    private int quantidadeSessoes;
    private Double valor;
    private String procedimento;
    private AquisicaoClienteResponse aquisicao;
}
