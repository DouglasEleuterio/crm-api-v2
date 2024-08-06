package br.com.tresptecnologia.service.evento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.evento.Evento;
import br.com.tresptecnologia.model.evento.EventoMapper;
import br.com.tresptecnologia.model.evento.EventoResponse;
import br.com.tresptecnologia.repository.evento.EventoRepository;
import br.com.tresptecnologia.service.cliente.ClienteService;
import br.com.tresptecnologia.service.color.ColorEventoService;
import br.com.tresptecnologia.service.regiao.RegiaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
public class EventoService extends BaseActiveService<Evento> implements IEventoService {

    private final ColorEventoService colorEventoService;
    private final JsonMapper jsonMapper;
    private final RegiaoService regiaoService;
    private final ClienteService clienteService;
    private final EventoMapper eventoMapper;

    protected EventoService(final EventoRepository repository,
                            final ColorEventoService colorEventoService,
                            final JsonMapper jsonMapper, RegiaoService regiaoService, ClienteService clienteService, EventoMapper eventoMapper) {
        super(repository);
        this.colorEventoService = colorEventoService;
        this.jsonMapper = jsonMapper;
        this.regiaoService = regiaoService;
        this.clienteService = clienteService;
        this.eventoMapper = eventoMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Aquisicao aquisicao) throws DomainException {
        for (AquisicaoProcedimento p : aquisicao.getProcedimentosDaAquisicao()) {
            var profissional = regiaoService.findById(p.getRegiaoOrigemId()).getProfissional();
            p.setProfissional(profissional);
            LocalDateTime ultimoAgendamento = null;
            for (int i = 0; i < p.getQuantidadeSessoes(); i++) {
                if(Objects.isNull(ultimoAgendamento))
                    ultimoAgendamento = LocalDateTime.of(p.getAquisicao().getDataAquisicao(), LocalTime.of(8, 0,0)).plusDays(p.getIntervaloEntreSessoes());
                else
                    ultimoAgendamento = ultimoAgendamento.plusDays(p.getIntervaloEntreSessoes());
                ultimoAgendamento = alterarSeFinalSemana(ultimoAgendamento);
                var duracao = regiaoService.findById(p.getRegiaoOrigemId()).getDuracao();
                var evento = Evento.builder()
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
    public List<EventoResponse> getPreAgendamentos(Long profssionalId) {
         return eventoMapper.toListResponse(getRepository().findAllByConfirmadoAndProfissionalId(false, profssionalId));
    }

    @Override
    public List<EventoResponse> getAgendamentos(Long profssionalId) {
        return eventoMapper.toListResponse(getRepository().findAllByConfirmadoAndProfissionalId(true, profssionalId));
    }

    @Override
    public Evento update(Long id, Evento updateT) throws DomainException {
        var oldEvento = findById(id);
        oldEvento.setStart(updateT.getAllDay() ? updateT.getStart().withHour(0) : updateT.getStart().minusHours(3)); //Front está incrementando 3 horas na edição
        oldEvento.setEnd(updateT.getAllDay() ? updateT.getStart().withHour(23) : updateT.getEnd().minusHours(3));//Front está incrementando 3 horas na edição
        oldEvento.setConfirmado(true);
        oldEvento.setBackgroundColor(colorEventoService.getColorByProcedimento(oldEvento.getAquisicaoProcedimento().getProcedimento()));
        return super.update(id, oldEvento);
    }

    private LocalDateTime alterarSeFinalSemana(LocalDateTime ultimoAgendamento) {
        if(ultimoAgendamento.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return ultimoAgendamento.plusDays(2);
        } if (ultimoAgendamento.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return ultimoAgendamento.plusDays(1);
        }
        return ultimoAgendamento;
    }

    public EventoRepository getRepository() {
        return (EventoRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }
}