package br.com.tresptecnologia.service;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.Pedido;
import br.com.tresptecnologia.model.pagamento.Pagamento;
import br.com.tresptecnologia.model.pedido.PedidoMapper;
import br.com.tresptecnologia.repository.pedido.PedidoRepository;
import br.com.tresptecnologia.service.rabbit.RabbitMQService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;


@Service
public class PedidoServiceImpl extends BaseActiveService<Pedido> implements PedidoService {

    private final RabbitMQService rabbitMQService;
    private final JsonMapper jsonMapper;


    protected PedidoServiceImpl(BaseRepository<Pedido> repository,
                                RabbitMQService rabbitMQService,
                                JsonMapper jsonMapper) {
        super(repository);
        this.rabbitMQService = rabbitMQService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Pedido create(Pedido pedido) throws DomainException {
        pedido.getItens().forEach(item -> item.setPedido(pedido));
        var response = super.create(pedido);
        rabbitMQService.sendEvent(response);
        return response;
    }

    @Override
    public void validate(Pedido pedido) throws DomainException {
        BigDecimal totalPedido = BigDecimal.valueOf(pedido.getValorTotalItens() - pedido.getDesconto());
        if(pedido.getValorTotalItens() != (pedido.getValorTotal()) + pedido.getDesconto())
            throw new DomainException("Valor dos pagamentos acrescido do desconto é inferior ao valor total dos produtos");

        BigDecimal totalPagamentos = BigDecimal.valueOf(calcularTotalDePagamentos(pedido));
        if(totalPedido.subtract(totalPagamentos).compareTo(BigDecimal.valueOf(0.05)) > 0)
            throw new DomainException("Valor dos pagamentos é diferente do total do pedido");
    }

    private Double calcularTotalDePagamentos(@NonNull Pedido pedido) {
        var pagamentosPorParcelamento = pedido.getPagamentos()
                .stream()
                .filter(
                        pagamento -> pagamento.getFormaDePagamento().getIsAceitaParcelamento())
                .toList();
        var pagamentosSemParcelamento = pedido.getPagamentos()
                .stream()
                .filter(
                        pagamento -> !pagamento.getFormaDePagamento().getIsAceitaParcelamento())
                .toList();

        AtomicReference<Double> totalDePagamentosPorParcelamento = new AtomicReference<>(0.0);
        for (Pagamento pagamento : pagamentosPorParcelamento) {
            pagamento.getParcelas().forEach(parcela -> totalDePagamentosPorParcelamento.updateAndGet(v -> v + parcela.getValor()));
        }

        Double totalDePagamentosSemParcelamento = 0.0;
        for (Pagamento pagamento : pagamentosSemParcelamento) {
            totalDePagamentosSemParcelamento += pagamento.getValor();
        }

        return totalDePagamentosSemParcelamento + totalDePagamentosPorParcelamento.get();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    public PedidoRepository getRepository() {
        return (PedidoRepository) super.getRepository();
    }
}
