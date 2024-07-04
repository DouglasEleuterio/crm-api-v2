package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.enumeration.procedimento.ETipoProcedimento;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcedimentoResponse implements BaseResponse {
    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;
    private ETipoProcedimento tipoProcedimento;
    private List<RegiaoResponse> regioes;
}
