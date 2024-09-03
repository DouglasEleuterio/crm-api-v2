package br.com.tresptecnologia.service.agendamento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.Agendamento;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.model.agendamento.AgendamentoMapperImpl;
import br.com.tresptecnologia.model.agendamento.AlterarAgendamentoRequest;
import br.com.tresptecnologia.repository.AgendamentoRepository;
import br.com.tresptecnologia.repository.evento.EventoRepository;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.color.ColorEventoService;
import br.com.tresptecnologia.service.evento.EventoService;
import br.com.tresptecnologia.service.profissional.ProfissionalService;
import br.com.tresptecnologia.service.regiao.RegiaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Service
public class AgendamentoService extends BaseActiveService<Agendamento> implements IAgendamentoService {

    private final ColorEventoService colorEventoService;
    private final RegiaoService regiaoService;
    private final ClienteService clienteService;
    private final JsonMapper jsonMapper;
    private final AgendamentoMapperImpl agendamentoMapperImpl;
    private final EventoService eventoService;
    private final EventoRepository eventoRepository;
    private final AgendamentoMapperImpl agendamentoMapper;
    private final ProfissionalService profissionalService;


    public AgendamentoService(final AgendamentoRepository repository,
                              final ColorEventoService colorEventoService,
                              final RegiaoService regiaoService,
                              final ClienteService clienteService, JsonMapper jsonMapper, AgendamentoMapperImpl agendamentoMapperImpl, EventoService eventoService, EventoRepository eventoRepository, AgendamentoMapperImpl agendamentoMapper, ProfissionalService profissionalService) {
        super(repository);
        this.colorEventoService = colorEventoService;
        this.regiaoService = regiaoService;
        this.clienteService = clienteService;
        this.jsonMapper = jsonMapper;
        this.agendamentoMapperImpl = agendamentoMapperImpl;
        this.eventoService = eventoService;
        this.eventoRepository = eventoRepository;
        this.agendamentoMapper = agendamentoMapper;
        this.profissionalService = profissionalService;
    }

    //todo - Para criar um agendamento, realizo a cópia de um evento, altero as propriedades e salvo.
    //todo - Dessa forma, o create está inutilizado até o momento.
    //todo - Não utilizei a mesma entidade, devido ao bug de ignorar os filtros dee evento quando publicado em produção.
    //todo - Desisti de tentar encontrar uma solução, simplismente não faz sentido, espero encontrar a resposta algum dia...
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Aquisicao aquisicao) throws DomainException {
        for (AquisicaoProcedimento p : aquisicao.getProcedimentosDaAquisicao()) {
            var profissional = regiaoService.findById(p.getRegiaoOrigemId()).getProfissional();
            p.setProfissional(profissional);
            LocalDateTime ultimoAgendamento = null;
            for (int i = 0; i < p.getQuantidadeSessoes(); i++) {
                if (Objects.isNull(ultimoAgendamento))
                    ultimoAgendamento = LocalDateTime.of(p.getAquisicao().getDataAquisicao(), LocalTime.of(8, 0, 0)).plusDays(p.getIntervaloEntreSessoes());
                else
                    ultimoAgendamento = ultimoAgendamento.plusDays(p.getIntervaloEntreSessoes());
                ultimoAgendamento = alterarSeFinalSemana(ultimoAgendamento);
                var duracao = regiaoService.findById(p.getRegiaoOrigemId()).getDuracao();
                var evento = Agendamento.builder()
                        .allDay(false)
                        .profissional(profissional)
                        .title(p.getProcedimento().concat(" - ").concat(p.getNome()).concat(" - ").concat(clienteService.findById(p.getAquisicao().getCliente().getId()).getNome()))
                        .start(ultimoAgendamento)
                        .end(ultimoAgendamento.plusMinutes(Objects.isNull(duracao) ? 15L : duracao))
                        .backgroundColor("#8d99ae")
                        .confirmado(false)
                        .aquisicaoProcedimento(p)
                        .build();

                super.create(evento);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelarAgendamento(Long id) throws DomainException {
        var agendamento = findById(id);
        agendamento.setConfirmado(false);
        agendamento.setBackgroundColor("#8d99ae");
        var evento = agendamentoMapper.toEvento(agendamento);
        eventoRepository.save(evento);
        getRepository().delete(agendamento);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmar(Long evento, AlterarAgendamentoRequest confirmacao) throws DomainException {
        var agendamento = findById(evento);
        agendamento.setDataAtualizacao(LocalDateTime.now());
        agendamento.setStart(confirmacao.getDataInicio());
        agendamento.setEnd(confirmacao.getDataFim());
        agendamento.setProfissional(profissionalService.findById(confirmacao.getProfissional().getId()));
        getRepository().save(agendamento);
    }

    @Override
    public Agendamento update(Long id, Agendamento updateT) throws DomainException {
        var oldEvento = findById(id);
        oldEvento.setStart(updateT.getAllDay() ? updateT.getStart().withHour(0) : updateT.getStart().minusHours(3)); //Front está incrementando 3 horas na edição
        oldEvento.setEnd(updateT.getAllDay() ? updateT.getStart().withHour(23) : updateT.getEnd().minusHours(3));//Front está incrementando 3 horas na edição
        oldEvento.setConfirmado(true);
        oldEvento.setBackgroundColor(colorEventoService.getColorByProcedimento(oldEvento.getAquisicaoProcedimento().getProcedimento()));
        return super.update(id, oldEvento);
    }

    private LocalDateTime alterarSeFinalSemana(LocalDateTime ultimoAgendamento) {
        if (ultimoAgendamento.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return ultimoAgendamento.plusDays(2);
        }
        if (ultimoAgendamento.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return ultimoAgendamento.plusDays(1);
        }
        return ultimoAgendamento;
    }


    public AgendamentoRepository getRepository() {
        return (AgendamentoRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}
