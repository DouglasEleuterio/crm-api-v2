package br.com.tresptecnologia.service.aquisicao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.pagamento.Pagamento;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoProcedimentoRepository;
import br.com.tresptecnologia.repository.aquisicao.AquisicaoRepository;
import br.com.tresptecnologia.repository.pagamento.PagamentoRepository;
import br.com.tresptecnologia.service.evento.EventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AquisicaoService extends BaseActiveService<Aquisicao> implements IAquisicaoService {

    private final JsonMapper jsonMapper;
    private final AquisicaoRepository aquisicaoRepository;
    private final AquisicaoProcedimentoRepository aquisicaoProcedimentoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final EventoService eventoService;

    protected AquisicaoService(final BaseRepository<Aquisicao> repository,
                               final JsonMapper jsonMapper,
                               final AquisicaoRepository aquisicaoRepository,
                               final AquisicaoProcedimentoRepository aquisicaoProcedimentoRepository,
                               final PagamentoRepository pagamentoRepository,
                               final EventoService eventoService) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.aquisicaoRepository = aquisicaoRepository;
        this.aquisicaoProcedimentoRepository = aquisicaoProcedimentoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.eventoService = eventoService;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Aquisicao create(Aquisicao aquisicao) throws DomainException {
        aquisicao.getProcedimentosDaAquisicao().forEach(proc -> proc.setAquisicao(aquisicao));
        aquisicao.getPagamentos().forEach(pgto -> pgto.setAquisicao(aquisicao));
        eventoService.create(aquisicao);
        return aquisicaoRepository.save(aquisicao);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Aquisicao update(Long id, Aquisicao aquisicao) throws DomainException {
        aquisicao.getProcedimentosDaAquisicao().forEach(proc -> proc.setAquisicao(aquisicao));
        aquisicao.getPagamentos().forEach(pgt -> pgt.setAquisicao(aquisicao));
        removerProcedimentos(aquisicao);
        removerPagamentos(aquisicao);
        //            if (Objects.nonNull(pgt.getId())) {
        //                pgt.setDataCriacao(pagamentoService.findById(pgt.getId()).getDataCriacao());
        //                pgt.setDataAtualizacao(LocalDateTime.now());
        //            }
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

    private void removerProcedimentos(Aquisicao aquisicao) throws DomainException {
        var toRemoveList = new ArrayList<AquisicaoProcedimento>();
        var aquisicaoOld = findById(aquisicao.getId());
        aquisicaoOld.getProcedimentosDaAquisicao().forEach(proc -> {
            if (aquisicao.getProcedimentosDaAquisicao().stream().noneMatch(aqs -> Objects.nonNull(aqs.getId()) && aqs.getId().equals(proc.getId()))) {
                toRemoveList.add(proc);
            }
        });

        aquisicaoOld.getProcedimentosDaAquisicao().removeAll(toRemoveList);
        aquisicaoProcedimentoRepository.deleteAll(toRemoveList);
    }

    private void removerPagamentos(Aquisicao aquisicao) throws DomainException {
        var toRemoveList = new ArrayList<Pagamento>();
        var aquisicaoOld = findById(aquisicao.getId());
        aquisicaoOld.getPagamentos().forEach(pgto -> {
            if (aquisicao.getPagamentos().stream().noneMatch(pg -> Objects.nonNull(pg.getId()) && pg.getId().equals(pgto.getId()))) {
                toRemoveList.add(pgto);
            }
        });
        toRemoveList.forEach(aquisicaoOld.getPagamentos()::remove);
        pagamentoRepository.deleteAll(toRemoveList);
    }
}
