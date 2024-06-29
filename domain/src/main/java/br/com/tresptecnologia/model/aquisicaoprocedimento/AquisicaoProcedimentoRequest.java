package br.com.tresptecnologia.model.aquisicaoprocedimento;

import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @Required(type = RequiredType.CREATE)
    private Long procedimentoOrigemId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

}
