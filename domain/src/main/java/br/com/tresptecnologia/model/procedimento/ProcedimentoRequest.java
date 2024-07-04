package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.enumeration.procedimento.ETipoProcedimento;
import br.com.tresptecnologia.shared.validation.Required;
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
public class ProcedimentoRequest {
    private Long id;
    @Required(label = "procedimento.nome")
    private String nome;
    private Double valor;
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;
    private ETipoProcedimento tipoProcedimento;
    private List<RegiaoRequest> regioes;
}
