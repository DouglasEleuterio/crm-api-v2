package br.com.tresptecnologia.model.aquisicaoprocedimento;

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
public class ProcedimentoRegiaoResponse {
    private Long id;
    private String nome;
}
