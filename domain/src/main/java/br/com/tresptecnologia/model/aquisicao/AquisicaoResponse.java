package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.model.aquisicaoprocedimento.AquisicaoProcedimentoResponse;
import br.com.tresptecnologia.model.cliente.ClienteResponse;
import br.com.tresptecnologia.model.entity.BaseResponse;
import br.com.tresptecnologia.model.pagamento.PagamentoResponse;
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
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoResponse implements BaseResponse {
    private Long id;
    private LocalDateTime dataAquisicao;
    private Double valorAquisicao;
    private Double valorDesconto;
    private ClienteResponse cliente;
    private AquisicaoProcedimentoResponse aquisicaoProcedimento;
    private Set<PagamentoResponse> pagamentos;
}
