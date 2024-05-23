package br.com.tresptecnologia.model.tabelaaliquotadiferenciada;

import br.com.tresptecnologia.enumeration.EnumSituacao;
import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TabelaAliquotaDiferenciadaResponse implements BaseResponse {

    private Long id;
    private String ncm;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private EnumSituacao enumSituacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCriacao;

}
