package br.com.tresptecnologia.service.aquisicao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoRepository;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import br.com.tresptecnologia.repository.pagamento.PagamentoRepository;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.pagamento.PagamentoService;
import br.com.tresptecnologia.service.procedimento.ProcedimentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AquisicaoService extends BaseActiveService<Aquisicao> implements IAquisicaoService {

    private final JsonMapper jsonMapper;
    private final AquisicaoRepository aquisicaoRepository;
    private final ProcedimentoService procedimentoService;
    private final HistoricoRepository historicoRepository;
    private final ClienteService clienteService;
    private final PagamentoService pagamentoService;
    private final PagamentoRepository pagamentoRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    protected AquisicaoService(BaseRepository<Aquisicao> repository, JsonMapper jsonMapper,
                               AquisicaoRepository aquisicaoRepository,
                               ProcedimentoService procedimentoService,
                               HistoricoRepository historicoRepository,
                               ClienteService clienteService, PagamentoService pagamentoService, PagamentoRepository pagamentoRepository) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.aquisicaoRepository = aquisicaoRepository;
        this.procedimentoService = procedimentoService;
        this.historicoRepository = historicoRepository;
        this.clienteService = clienteService;
        this.objectMapper.findAndRegisterModules();
        this.pagamentoService = pagamentoService;
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Aquisicao create(Aquisicao aquisicao) throws DomainException {
        vincularAquisicaoProcedimento(aquisicao);
        vincularPagamentos(aquisicao);
        return aquisicaoRepository.save(aquisicao);
    }

    private void vincularPagamentos(Aquisicao aquisicao) {
        aquisicao.getPagamentos().forEach(pgto -> {
            if(Objects.isNull(pgto.getAquisicao()))
                pgto.setAquisicao(aquisicao);
            //Quando edição, buscar data da criação da entidade e atribuir;
            if(Objects.nonNull(pgto.getId())) {
                pgto.setDataCriacao(pagamentoRepository.findById(pgto.getId()).orElseThrow().getDataCriacao());
                pgto.setSituacao(pagamentoRepository.findById(pgto.getId()).orElseThrow().getSituacao());
            }
        });
    }

    @Override
    public Aquisicao update(Long id, Aquisicao aquisicao) throws DomainException {
        var old = findById(id);
        aquisicao.setDataCriacao(old.getDataCriacao());
        aquisicao.setDataAtualizacao(LocalDateTime.now());
        vincularAquisicaoProcedimento(aquisicao);
        vincularPagamentos(aquisicao);
//        try {
//            var newJson = objectMapper.writeValueAsString(aquisicao);
//            var oldJson = objectMapper.writeValueAsString(oldOjb);
//            var auditoriaAtual = Auditoria.builder()
//                    .situacaoRegistro(ESituacaoRegistro.ATUAL)
//                    .dado(newJson)
//                    .build();
//            var auditoriaAnterior = Auditoria.builder()
//                    .situacaoRegistro(ESituacaoRegistro.ANTERIOR)
//                    .dado(oldJson)
//                    .build();
//
//            var auditoriaSet = new HashSet<Auditoria>();
//            auditoriaSet.add(auditoriaAtual);
//            auditoriaSet.add(auditoriaAnterior);
//            var historico = Historico.builder()
//                    .dataOcorrencia(LocalDateTime.now())
//                    .idUsuario(AuditRevisionInfo.obterInfo().getUserId())
//                    .idEntidadeGeradora(id)
//                    .nomeUsuario(AuditRevisionInfo.obterInfo().getUserName())
//                    .tipoEntidade(ETipoEntidade.AQUISICAO)
//                    .tipoEvento(EEvento.EDICAO)
//                    .auditorias(auditoriaSet)
//                    .build();
//            auditoriaSet.forEach(audit -> audit.setHistorico(historico));
//            historicoRepository.save(historico);
//        } catch (JsonProcessingException e) {
//            throw new DomainException(e);
//        }
        return super.update(id, aquisicao);
    }


    private void vincularCliente(Aquisicao aquisicao) throws DomainException {
        var cliente = clienteService.findById(aquisicao.getCliente().getId());
        aquisicao.setCliente(cliente);
    }

    private void vincularAquisicaoProcedimento(Aquisicao aquisicao) throws DomainException {
        aquisicao.getProcedimentos().forEach(proc -> {
            if (Objects.isNull(proc.getAquisicao()))
                proc.setAquisicao(aquisicao);
            proc.getRegioes().forEach(reg -> {
                if (Objects.isNull(reg.getProcedimento()))
                    reg.setProcedimento(proc);
            });
        });
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
