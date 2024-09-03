package br.com.tresptecnologia.model.agendamento;

import br.com.tresptecnologia.model.entity.BaseEntityRequest;
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
public class AlterarAgendamentoRequest {
    private BaseEntityRequest id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private BaseEntityRequest profissional;
}
