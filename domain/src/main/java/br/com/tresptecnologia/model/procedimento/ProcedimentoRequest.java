package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.shared.validation.Required;
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
public class ProcedimentoRequest {
    private Long id;
    @Required(label = "procedimento.nome")
    private String nome;
    @Required(label = "procedimento.valor")
    private Double valor;
    @Required(label = "procedimento.quantidade-sessoes")
    private Integer quantidadeSessoes;
    private Integer intervaloEntreSessoes;
}
