package br.com.tresptecnologia.service.aquisicao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoRepository;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.procedimento.ProcedimentoService;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AquisicaoService extends BaseActiveService<Aquisicao> implements IAquisicaoService {

    private final JsonMapper jsonMapper;
    private final AquisicaoRepository aquisicaoRepository;
    private final ProcedimentoService procedimentoService;
    private final ClienteService clienteService;

    protected AquisicaoService(BaseRepository<Aquisicao> repository, JsonMapper jsonMapper,
                               AquisicaoRepository aquisicaoRepository, ProcedimentoService procedimentoService, ClienteService clienteService) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.aquisicaoRepository = aquisicaoRepository;
        this.procedimentoService = procedimentoService;
        this.clienteService = clienteService;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Aquisicao create(Aquisicao aquisicao) throws DomainException {
        vincularAquisicaoProcedimento(aquisicao);
        vincularCliente(aquisicao);
        vincularPagamento(aquisicao);
        validarPagamento(aquisicao);
        return aquisicaoRepository.save(aquisicao);
    }

    private void vincularPagamento(Aquisicao aquisicao) {
        aquisicao.getPagamentos().forEach(pgt -> pgt.setAquisicao(aquisicao));
        aquisicao.getPagamentos().forEach(pgt -> pgt.getPagamentos().forEach(parcelaPagamento -> {
            parcelaPagamento.setPagamento(pgt);
            parcelaPagamento.setDataCriacao(LocalDateTime.now());
            parcelaPagamento.setDataAtualizacao(LocalDateTime.now());
        }));
    }

    private void validarPagamento(Aquisicao aquisicao) throws DomainException {
        var valorProcedimento = aquisicao.getAquisicaoProcedimento().getValor();
        var valorDesconto = Objects.isNull(aquisicao.getValorDesconto()) ? 0.00 : aquisicao.getValorDesconto();
        var valorAquisicao = aquisicao.getValorAquisicao();
        if(valorAquisicao + valorDesconto < valorProcedimento)
            throw new DomainException(Message.toLocale("valor-aquisicao-inferior-valor-procedimento"));
        validarPagamentos(aquisicao);
    }

    private void validarPagamentos(Aquisicao aquisicao) throws DomainException {
        var valorAquisicao = aquisicao.getValorAquisicao();
        AtomicReference<Double> valorPagamentos = new AtomicReference<>(0.0);

        aquisicao.getPagamentos().forEach(pgto -> valorPagamentos.updateAndGet(v -> v + pgto.getValorPagamento()));

        if(valorPagamentos.get() < valorAquisicao)
            throw new DomainException(Message.toLocale("valor-pagamento-inferior-aquisicao"));

        validarParcelas(aquisicao);
    }

    private void validarParcelas(Aquisicao aquisicao) throws DomainException {
        for (Pagamento pagamento : aquisicao.getPagamentos()) {
            var valorPagamento = pagamento.getValorPagamento();
            AtomicDouble valorTotalParcelas = new AtomicDouble();
            pagamento.getPagamentos().forEach(parcelaPagamento -> valorTotalParcelas.addAndGet((parcelaPagamento.getValorCredito() + parcelaPagamento.getValorTaxa())));
            if(valorTotalParcelas.get() != valorPagamento)
                throw new DomainException(Message.toLocale("valor-parcelas-inferior-pagamento", pagamento.getFormaPagamento().getLabel()));
        }

    }

    private void vincularCliente(Aquisicao aquisicao) {
        var pacienteOpt = clienteService.findByCPF(aquisicao.getCliente().getCpf());
        pacienteOpt.ifPresent(aquisicao::setCliente);
    }

    private void vincularAquisicaoProcedimento(Aquisicao aquisicao) throws DomainException {
        var procedimento = procedimentoService.findById(aquisicao.getProcedimento().getId());
        aquisicao.setAquisicaoProcedimento(AquisicaoProcedimento.builder()
                .nome(procedimento.getNome())
                .valor(procedimento.getValor())
                .quantidadeSessoes(procedimento.getQuantidadeSessoes())
                .intervaloEntreSessoes(procedimento.getIntervaloEntreSessoes())
                .build());
    }
}
