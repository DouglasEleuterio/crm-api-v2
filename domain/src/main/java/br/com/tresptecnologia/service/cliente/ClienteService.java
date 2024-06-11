package br.com.tresptecnologia.service.cliente;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.cliente.Cliente;
import br.com.tresptecnologia.entity.historico.Auditoria;
import br.com.tresptecnologia.entity.historico.EEvento;
import br.com.tresptecnologia.entity.historico.ESituacaoRegistro;
import br.com.tresptecnologia.entity.historico.ETipoEntidade;
import br.com.tresptecnologia.entity.historico.Historico;
import br.com.tresptecnologia.repository.cliente.ClienteRepository;
import br.com.tresptecnologia.repository.historico.HistoricoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
public class ClienteService extends BaseActiveService<Cliente> implements IClienteService {

    private final JsonMapper jsonMapper;
    private final HistoricoRepository historicoRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    protected ClienteService(BaseRepository<Cliente> repository, JsonMapper jsonMapper, HistoricoRepository historicoRepository) {
        super(repository);
        this.historicoRepository = historicoRepository;
        objectMapper.registerModule(new JavaTimeModule());
        this.jsonMapper = jsonMapper;
    }

    public ClienteRepository getRepository() {
        return (ClienteRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

    @Override
    public Cliente update(Long id, Cliente updateT) throws DomainException {
        var oldOjb = super.findById(id);
        try {
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
    public void active(Long id, boolean ativo) throws DomainException {
        var historico = Historico.builder()
                .dataOcorrencia(LocalDateTime.now())
                .idUsuario(AuditRevisionInfo.obterInfo().getUserId())
                .idEntidadeGeradora(id)
                .nomeUsuario(AuditRevisionInfo.obterInfo().getUserName())
                .tipoEntidade(ETipoEntidade.CLIENTE)
                .tipoEvento(ativo ? EEvento.ATIVACAO : EEvento.INATIVACAO)
                .build();
        historicoRepository.save(historico);
        super.active(id, ativo);
    }
}
