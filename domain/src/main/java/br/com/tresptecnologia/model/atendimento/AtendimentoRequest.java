package br.com.tresptecnologia.model.atendimento;

import br.com.tresptecnologia.model.documento.DocumentoRequest;
import br.com.tresptecnologia.model.entity.BaseEntityRequest;
import br.com.tresptecnologia.shared.validation.RequiredList;
import br.com.tresptecnologia.shared.validation.RequiredType;
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

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private DocumentoRequest documento;
    private BaseEntityRequest agendamento;
    @RequiredList(label = "profissionais", type = RequiredType.ALL, customMessage = "Profissional(is) não informado")
    private List<BaseEntityRequest> profissionais;

}
