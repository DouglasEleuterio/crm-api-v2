package br.com.tresptecnologia.model.documento;

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
public class DocumentoRequest {

    private Long id;
    @Required(label = "documento.conteudo")
    private String conteudo;
}
