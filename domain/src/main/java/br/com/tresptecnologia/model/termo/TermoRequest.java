package br.com.tresptecnologia.model.termo;

import br.com.tresptecnologia.model.documento.DocumentoRequest;
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
public class TermoRequest {
    private Long id;
    private Integer versao;
    private DocumentoRequest documento;
    private BaseEntityRequest procedimento;
}
