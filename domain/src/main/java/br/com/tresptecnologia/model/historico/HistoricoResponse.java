package br.com.tresptecnologia.model.historico;

import br.com.tresptecnologia.entity.historico.EEvento;
import br.com.tresptecnologia.entity.historico.ETipoEntidade;
import br.com.tresptecnologia.model.auditoria.AuditoriaResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoResponse implements BaseResponse {
    private Long id;
    private EEvento tipoEvento;
    private LocalDateTime dataOcorrencia;
    private String idUsuario;
    private String nomeUsuario;
    private Long idEntidadeGeradora;
    private ETipoEntidade tipoEntidade;
    private Set<AuditoriaResponse> auditorias;

}
