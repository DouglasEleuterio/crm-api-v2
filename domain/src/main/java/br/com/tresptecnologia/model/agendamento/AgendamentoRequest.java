package br.com.tresptecnologia.model.agendamento;

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
public class AgendamentoRequest {

    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Boolean allDay;
}
