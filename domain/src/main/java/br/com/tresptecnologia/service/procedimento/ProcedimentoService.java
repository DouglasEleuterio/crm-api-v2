package br.com.tresptecnologia.service.procedimento;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.historico.Auditoria;
import br.com.tresptecnologia.entity.historico.EEvento;
import br.com.tresptecnologia.entity.historico.ESituacaoRegistro;
import br.com.tresptecnologia.entity.historico.ETipoEntidade;
import br.com.tresptecnologia.entity.historico.Historico;
import br.com.tresptecnologia.entity.procedimento.Procedimento;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@Service
public class ProcedimentoService extends BaseActiveService<Procedimento> implements IProcedimentoService {

    private final JsonMapper jsonMapper;
    private final HistoricoRepository historicoRepository;
    private final ObjectMapper objectMapper;

    protected ProcedimentoService(final BaseRepository<Procedimento> repository,
                                  final JsonMapper jsonMapper,
                                  final HistoricoRepository historicoRepository,
                                  final ObjectMapper objectMapper) {
        super(repository);
        this.historicoRepository = historicoRepository;
        this.jsonMapper = jsonMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Procedimento update(Long id, Procedimento updateT) throws DomainException {
        var oldOjb = super.findById(id);
        updateT.getRegioes().forEach(regiao -> regiao.setProcedimento(updateT));

        try {
            JavaTimeModule javaTimeModule = new JavaTimeModule();
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")));
            var newJson = objectMapper.writeValueAsString(updateT);
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
                    .tipoEntidade(ETipoEntidade.CLIENTE)
                    .tipoEvento(EEvento.EDICAO)
                    .auditorias(auditoriaSet)
                    .build();
            auditoriaSet.forEach(audit -> audit.setHistorico(historico));
            historicoRepository.save(historico);
        } catch (JsonProcessingException e) {
            throw new DomainException(e);
        }
        return super.update(id, updateT);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Procedimento create(Procedimento procedimento) throws DomainException {
        procedimento.getRegioes().forEach(regiao -> regiao.setProcedimento(procedimento));
        var saved =  super.create(procedimento);
        var historico = Historico.builder()
                .dataOcorrencia(LocalDateTime.now())
                .idUsuario(AuditRevisionInfo.obterInfo().getUserId())
                .idEntidadeGeradora(saved.getId())
                .nomeUsuario(AuditRevisionInfo.obterInfo().getUserName())
                .tipoEntidade(ETipoEntidade.CLIENTE)
                .tipoEvento(EEvento.CADASTRO)
                .build();
        historicoRepository.save(historico);
        return saved;
    }
}
