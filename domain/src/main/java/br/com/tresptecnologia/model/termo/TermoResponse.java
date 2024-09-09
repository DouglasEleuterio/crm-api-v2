package br.com.tresptecnologia.model.termo;

import br.com.tresptecnologia.model.documento.DocumentoResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.procedimento.ProcedimentoResponse;
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
public class TermoResponse implements BaseResponse {
    private Long id;
    private Integer versao;
    private DocumentoResponse documento;
    private ProcedimentoResponse procedimento;
}
