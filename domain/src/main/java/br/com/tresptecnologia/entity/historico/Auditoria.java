package br.com.tresptecnologia.entity.historico;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Auditoria {
    private ESituacaoRegistro situacaoRegistro;
    private String dado;
}
