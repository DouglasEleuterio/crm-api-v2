package br.com.tresptecnologia.service.aquisicao;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.historico.*;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.model.aquisicao.AquisicaoMapper;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoRepository;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import br.com.tresptecnologia.service.AquisicaoProcedimentoService;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.procedimento.ProcedimentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AquisicaoService extends BaseActiveService<Aquisicao> implements IAquisicaoService {

    private final JsonMapper jsonMapper;
    private final AquisicaoRepository aquisicaoRepository;
    private final ProcedimentoService procedimentoService;
    private final HistoricoRepository historicoRepository;
    private final ClienteService clienteService;
    ObjectMapper objectMapper = new ObjectMapper();

    protected AquisicaoService(BaseRepository<Aquisicao> repository, JsonMapper jsonMapper,
                               AquisicaoRepository aquisicaoRepository,
                               ProcedimentoService procedimentoService,
                               HistoricoRepository historicoRepository,
                               ClienteService clienteService,
                               AquisicaoMapper aquisicaoMapper,
                               AquisicaoProcedimentoService aquisicaoProcedimentoService) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.aquisicaoRepository = aquisicaoRepository;
        this.procedimentoService = procedimentoService;
        this.historicoRepository = historicoRepository;
        this.clienteService = clienteService;
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Aquisicao create(Aquisicao aquisicao) throws DomainException {
        vincularAquisicaoProcedimento(aquisicao, false);
        vincularCliente(aquisicao);
        vincularPagamento(aquisicao);
        validarPagamento(aquisicao);
        return aquisicaoRepository.save(aquisicao);
    }

    @Override
    public Aquisicao update(Long id, Aquisicao aquisicao) throws DomainException {

        var oldOjb = super.findById(id);

        vincularAquisicaoProcedimento(aquisicao, true);

        try {
            var newJson = objectMapper.writeValueAsString(aquisicao);
            var oldJson = objectMapper.writeValueAsString(oldOjb);
            var auditoriaAtual = Auditoria.builder()
                    .situacaoRegistro(ESituacaoRegistro.ATUAL)
                    .dado(newJson)
                    .build();
            var auditoriaAnterior = Auditoria.builder()
                    .situacaoRegistro(ESituacaoRegistro.ANTERIOR)
                    .dado(oldJson)
                    .build();

            var auditoriaSet = new HashSet<Auditoria>();
            auditoriaSet.add(auditoriaAtual);
            auditoriaSet.add(auditoriaAnterior);
            var historico = Historico.builder()
                    .dataOcorrencia(LocalDateTime.now())
                    .idUsuario(AuditRevisionInfo.obterInfo().getUserId())
                    .idEntidadeGeradora(id)
                    .nomeUsuario(AuditRevisionInfo.obterInfo().getUserName())
                    .tipoEntidade(ETipoEntidade.AQUISICAO)
                    .tipoEvento(EEvento.EDICAO)
                    .auditorias(auditoriaSet)
                    .build();
            auditoriaSet.forEach(audit -> audit.setHistorico(historico));
            historicoRepository.save(historico);
        } catch (JsonProcessingException e) {
            throw new DomainException(e);
        }

        vincularCliente(aquisicao);
        vincularPagamento(aquisicao);
        validarPagamento(aquisicao);
        return super.update(id, aquisicao);
    }

    private void vincularPagamento(Aquisicao aquisicao) {
        aquisicao.getPagamentos().forEach(pgt -> pgt.setAquisicao(aquisicao));
        aquisicao.getPagamentos().forEach(pgt -> pgt.getParcelas().forEach(parcelaPagamento -> {
            parcelaPagamento.setPagamento(pgt);
            parcelaPagamento.setDataCriacao(LocalDateTime.now());
            parcelaPagamento.setDataAtualizacao(LocalDateTime.now());
        }));
    }

    private void validarPagamento(Aquisicao aquisicao) throws DomainException {
        var valorProcedimento = aquisicao.getProcedimentos()
                .stream()
                .map(AquisicaoProcedimento::getValor).reduce(0.0, Double::sum);
        var valorDesconto = Objects.isNull(aquisicao.getValorDesconto()) ? 0.00 : aquisicao.getValorDesconto();
        var valorAquisicao = aquisicao.getValorAquisicao();
        if (valorAquisicao + valorDesconto < valorProcedimento)
            throw new DomainException(Message.toLocale("valor-aquisicao-inferior-valor-procedimento"));
        validarPagamentos(aquisicao);
    }

    private void validarPagamentos(Aquisicao aquisicao) throws DomainException {
        var valorAquisicao = aquisicao.getValorAquisicao();
        AtomicReference<Double> valorPagamentos = new AtomicReference<>(0.0);

        aquisicao.getPagamentos().forEach(pgto -> valorPagamentos.updateAndGet(v -> v + pgto.getValorPagamento()));

        if (valorPagamentos.get() < valorAquisicao)
            throw new DomainException(Message.toLocale("valor-pagamento-inferior-aquisicao"));

        validarParcelas(aquisicao);
    }

    private void validarParcelas(Aquisicao aquisicao) throws DomainException {
        for (Pagamento pagamento : aquisicao.getPagamentos()) {
            var valorPagamento = pagamento.getValorPagamento();
            AtomicDouble valorTotalParcelas = new AtomicDouble();
            pagamento.getParcelas().forEach(parcelaPagamento -> valorTotalParcelas.addAndGet((parcelaPagamento.getValorCredito() + parcelaPagamento.getValorTaxa())));
            if (valorTotalParcelas.get() != valorPagamento)
                throw new DomainException(Message.toLocale("valor-parcelas-inferior-pagamento", pagamento.getFormaPagamento().getLabel()));
        }

    }

    private void vincularCliente(Aquisicao aquisicao) {
        var pacienteOpt = clienteService.findByCPF(aquisicao.getCliente().getCpf());
        pacienteOpt.ifPresent(aquisicao::setCliente);
    }

    private void vincularAquisicaoProcedimento(Aquisicao aquisicao, boolean isUpdate) throws DomainException {

        if (!isUpdate) {
            for (AquisicaoProcedimento aquisicaoProcedimento : aquisicao.getProcedimentos()) {
                this.buildAquisicaoProcedimento(aquisicaoProcedimento);
            }
        } else {
            //Caso esteja editando uma aquisição, se o procedimento da aquisição foi alterado, alteração não deve se propagar para aquisição anterior a mudança.
            for (AquisicaoProcedimento aquisicaoProcedimento : aquisicao.getProcedimentos()) {
                // Foram incluídos outros procedimentos na aquisição.
                if(Objects.isNull(aquisicaoProcedimento.getId())) {
                    this.buildAquisicaoProcedimento(aquisicaoProcedimento);
                }
            }
        }
        aquisicao.getProcedimentos().forEach(proc -> proc.setAquisicao(aquisicao));
    }

    /**
     * Será recebido do front, seguintes dados do procedimento:
     * - ID
     * - Quantidade Sessões
     * - Intervalo entre Sessões
     * Não permitir que Nome e Preço sejam alterados por requisições mal intencionadas e permitir que quantidade de sessões e intervalo entre sessões sejam diferentes do padrão.
     */
    private void buildAquisicaoProcedimento(AquisicaoProcedimento aqProcedimento) throws DomainException {
        var procedimento = procedimentoService.findById(aqProcedimento.getProcedimentoOrigemId());
        aqProcedimento.setNome(procedimento.getNome());
//        aqProcedimento.setValor(procedimento.getValor());
    }
}
