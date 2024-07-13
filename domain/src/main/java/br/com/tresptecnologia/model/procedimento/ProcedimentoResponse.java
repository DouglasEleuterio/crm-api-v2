package br.com.tresptecnologia.model.procedimento;

import br.com.tresptecnologia.model.entity.BaseResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcedimentoResponse implements BaseResponse {
    private Long id;
    private String nome;
    private List<RegiaoResponse> regioes;
    private boolean persistida = true;
}
