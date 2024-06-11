package br.com.tresptecnologia.model.auditoria;

import br.com.tresptecnologia.entity.historico.ESituacaoRegistro;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
