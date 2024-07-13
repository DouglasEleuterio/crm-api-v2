package br.com.tresptecnologia.model.procedimento;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoRequest {

    private Long id;
    private String nome;
    private int quantidadeSessoes;
    private int intervaloEntreSessoes;
    private Double valor;
    private Boolean persistida;

    public Long getId() {
        return persistida ? id : null;
    }
}


