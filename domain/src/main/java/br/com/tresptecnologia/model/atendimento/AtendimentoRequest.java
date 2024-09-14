package br.com.tresptecnologia.model.atendimento;

import br.com.tresptecnologia.model.documento.DocumentoRequest;
import br.com.tresptecnologia.model.entity.BaseEntityRequest;
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
public class AtendimentoRequest {

    private LocalDateTime data;
    private DocumentoRequest observacao;
    private BaseEntityRequest agendamento;
    private List<BaseEntityRequest> profissionais;

}
