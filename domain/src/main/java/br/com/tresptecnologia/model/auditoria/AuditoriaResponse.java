package br.com.tresptecnologia.model.auditoria;

import br.com.tresptecnologia.entity.historico.ESituacaoRegistro;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaResponse implements BaseResponse {
    private Long id;
    private ESituacaoRegistro situacaoRegistro;
    private String dado;
}
