package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.model.profissional.ProfissionalResponse;
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
public class RegiaoResponse {

    private Long id;
    private String nome;
    private int quantidadeSessoes;
    private int intervaloEntreSessoes;
    private int duracao;
    private Double valor;
    private ProfissionalResponse profissional;

}
