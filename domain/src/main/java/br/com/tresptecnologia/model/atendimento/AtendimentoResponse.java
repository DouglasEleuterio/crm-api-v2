package br.com.tresptecnologia.model.atendimento;

import br.com.tresptecnologia.model.agendamento.AgendamentoResponse;
import br.com.tresptecnologia.model.documento.DocumentoResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.profissional.ProfissionalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtendimentoResponse implements BaseResponse {

    private LocalDateTime data;
    private DocumentoResponse observacao;
    private AgendamentoResponse agendamento;
    private List<ProfissionalResponse> profissionais;
}
