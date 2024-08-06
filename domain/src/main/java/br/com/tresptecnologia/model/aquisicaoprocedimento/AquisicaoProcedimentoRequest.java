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
public class AquisicaoProcedimentoRequest {

    private Long id;
    private Long regiaoOrigemId;
    private String nome;
    private Integer intervaloEntreSessoes;
    private Integer quantidadeSessoes;
    private Double valor;
    private String procedimento;
    private Integer duracao;
    private BaseEntityRequest profissional;
}
