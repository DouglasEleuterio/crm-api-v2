package br.com.tresptecnologia.service.cliente;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.message.Message;
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
import br.com.tresptecnologia.service.cidade.CidadeService;
import br.com.tresptecnologia.service.endereco.IEnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

@Service
public class ClienteService extends BaseActiveService<Cliente> implements IClienteService {

    private final IEnderecoService enderecoService;

    private final JsonMapper jsonMapper;
    private final HistoricoRepository historicoRepository;
    private final CidadeService cidadeService;
    private final ClienteRepository clienteRepository;
    private final ObjectMapper objectMapper;

    protected ClienteService(BaseRepository<Cliente> repository,
                             IEnderecoService enderecoService,
                             JsonMapper jsonMapper,
                             HistoricoRepository historicoRepository,
                             CidadeService cidadeService,
                             ClienteRepository clienteRepository, ObjectMapper objectMapper) {
        super(repository);
        this.objectMapper = objectMapper;
        this.enderecoService = enderecoService;
        this.historicoRepository = historicoRepository;
        this.jsonMapper = jsonMapper;
        this.cidadeService = cidadeService;
        this.clienteRepository = clienteRepository;
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

        var endereco = enderecoService.findById(updateT.getEndereco().getId());
        updateT.getEndereco().setId(endereco.getId());
        updateT.getEndereco().setDataCriacao(endereco.getDataCriacao());
        updateT.getEndereco().setDataAtualizacao(endereco.getDataAtualizacao());

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

    @Override
    public Optional<Cliente> findByCPF(String cpf) {
        return getRepository().findByCpf(cpf);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws DomainException {
        var cliente = findById(id);
        cliente.setSituacao(false);
        super.update(id, cliente);
        var historico = Historico.builder()
                .dataOcorrencia(LocalDateTime.now())
                .idUsuario(AuditRevisionInfo.obterInfo().getUserId())
                .idEntidadeGeradora(id)
                .nomeUsuario(AuditRevisionInfo.obterInfo().getUserName())
                .tipoEntidade(ETipoEntidade.CLIENTE)
                .tipoEvento(EEvento.EXCLUSAO)
                .build();
        historicoRepository.save(historico);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Cliente create(Cliente cliente) throws DomainException {
        validateInternal(cliente);
        cliente.getEndereco().setCidade(cidadeService.findById(cliente.getEndereco().getCidade().getId()));
        var saved = super.create(cliente);
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

    private void validateInternal(Cliente cliente) throws DomainException {
        var clienteOpt = clienteRepository.findByCpf(cliente.getCpf());
        if(clienteOpt.isPresent()) {
            var cli = clienteOpt.get();
            var situacao = cli.getSituacao();
            if(!situacao)
                throw new DomainException(Message.toLocale("cliente-cpf-inativo", cliente.getCpf()));
            else
                throw new DomainException(Message.toLocale("cliente-existente", cliente.getCpf()));
        }
    }
}
