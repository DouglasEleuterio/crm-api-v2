package br.com.tresptecnologia.service.aquisicao;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.historico.Auditoria;
import br.com.tresptecnologia.entity.historico.EEvento;
import br.com.tresptecnologia.entity.historico.ESituacaoRegistro;
import br.com.tresptecnologia.entity.historico.ETipoEntidade;
import br.com.tresptecnologia.entity.historico.Historico;
import br.com.tresptecnologia.model.aquisicao.AquisicaoMapper;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoRepository;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import br.com.tresptecnologia.service.AquisicaoProcedimentoService;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.procedimento.ProcedimentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;

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

    private void vincularCliente(Aquisicao aquisicao) throws DomainException {
        var cliente = clienteService.findById(aquisicao.getCliente().getId());
        aquisicao.setCliente(cliente);
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
