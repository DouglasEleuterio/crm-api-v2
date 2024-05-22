package br.com.tresptecnologia.model.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredSize;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class TabelaAliquotaDiferenciadaRequest {

    private Long id;

    @RequiredSize(label = "tabelaaliquotadiferenciada.ncm", min = 8, max = 8)
    private String ncm;
    @Required(label = "tabelaaliquotadiferenciada.iniciovigencia")
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
}
