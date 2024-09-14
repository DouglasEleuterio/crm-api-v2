package br.com.tresptecnologia.service.atendimento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.atendimento.Atendimento;
import br.com.tresptecnologia.model.atendimento.AtendimentoMapper;
import br.com.tresptecnologia.model.atendimento.AtendimentoRequest;
import br.com.tresptecnologia.model.atendimento.AtendimentoResponse;
import br.com.tresptecnologia.service.agendamento.AgendamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
public class AtendimentoService extends BaseActiveService<Atendimento> implements IAtendimentoService {

    private final JsonMapper jsonMapper;
    private final AtendimentoMapper mapper;
    private final AgendamentoService agendamentoService;

    protected AtendimentoService(BaseRepository<Atendimento> repository, JsonMapper jsonMapper, AtendimentoMapper mapper, AgendamentoService agendamentoService) {
        super(repository);
        this.jsonMapper = jsonMapper;
        this.mapper = mapper;
        this.agendamentoService = agendamentoService;
    }

    @Transactional(rollbackFor = Exception.class)
    public AtendimentoResponse inserirAtendimento(AtendimentoRequest atendimento, Function<Atendimento, AtendimentoResponse> converter) throws DomainException {
        var agendamento = agendamentoService.findById(atendimento.getAgendamento().getId());
        agendamento.setExecutado(true);
        return converter.apply(getRepository().save(mapper.fromRequest(atendimento)));
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
