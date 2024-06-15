package br.com.tresptecnologia.model.aquisicao;

import br.com.tresptecnologia.model.aquisicaoprocedimento.AquisicaoProcedimentoRequest;
import br.com.tresptecnologia.model.cliente.ClienteRequest;
import br.com.tresptecnologia.model.entity.BaseEntityRequest;
import br.com.tresptecnologia.model.pagamento.PagamentoRequest;
import br.com.tresptecnologia.shared.validation.Required;
import br.com.tresptecnologia.shared.validation.RequiredList;
import br.com.tresptecnologia.shared.validation.RequiredType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AquisicaoRequest {

    private Long id;
    @Required(label = "aquisicao.data-aquisicao")
    private LocalDateTime dataAquisicao;
    @Required(label = "aquisicao.valor-aquisicao")
    private Double valorAquisicao;
    @Required(label = "aquisicao.valor-desconto")
    private Double valorDesconto;
    @Required(label = "aquisicao.cliente")
    private ClienteRequest cliente;
    @Required(label = "aquisicao.procedimento", type = RequiredType.CREATE)
    private BaseEntityRequest procedimento;
    @RequiredList(label = "aquisicao.pagamento", alias = "pagamento(s)")
    private Set<PagamentoRequest> pagamentos;
    @Required(label = "aquisicao.procedimento", type = RequiredType.UPDATE)
    private AquisicaoProcedimentoRequest aquisicaoProcedimento;
}
