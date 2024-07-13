package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredList;
import lombok.*;

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
    @RequiredList(label = "regiões", message = "Procedimento deve ter pelo menos uma região", alias = "regiões")
    private List<RegiaoRequest> regioes;
}
