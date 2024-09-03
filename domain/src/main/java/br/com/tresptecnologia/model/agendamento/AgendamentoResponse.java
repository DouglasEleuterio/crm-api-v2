package br.com.tresptecnologia.model.agendamento;

import br.com.tresptecnologia.model.aquisicaoprocedimento.AquisicaoProcedimentoResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.profissional.ProfissionalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponse implements BaseResponse {

    private Long id;
    private boolean allDay;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private String backgroundColor;
    private Boolean confirmado;
    private AquisicaoProcedimentoResponse aquisicaoProcedimento;
    private ProfissionalResponse profissional;
}
