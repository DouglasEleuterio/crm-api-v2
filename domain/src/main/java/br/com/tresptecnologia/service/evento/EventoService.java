package br.com.tresptecnologia.service.evento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.aquisicao.AquisicaoProcedimento;
import br.com.tresptecnologia.entity.evento.Evento;
import br.com.tresptecnologia.repository.evento.EventoRepository;
import br.com.tresptecnologia.service.color.ColorEventoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Service
public class EventoService extends BaseActiveService<Evento> implements IEventoService {

    private final ColorEventoService colorEventoService;
    private final JsonMapper jsonMapper;

    protected EventoService(final EventoRepository repository,
                            final ColorEventoService colorEventoService,
                            final JsonMapper jsonMapper) {
        super(repository);
        this.colorEventoService = colorEventoService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Aquisicao aquisicao) throws DomainException {
        for (AquisicaoProcedimento p : aquisicao.getProcedimentosDaAquisicao()) {
            LocalDateTime ultimoAgendamento = null;
            for (int i = 0; i < p.getQuantidadeSessoes(); i++) {
                if(Objects.isNull(ultimoAgendamento))
                    ultimoAgendamento = LocalDateTime.of(p.getAquisicao().getDataAquisicao(), LocalTime.of(8, 0,0)).plusDays(p.getIntervaloEntreSessoes());
                else
                    ultimoAgendamento = ultimoAgendamento.plusDays(p.getIntervaloEntreSessoes());
                ultimoAgendamento = alterarSeFinalSemana(ultimoAgendamento);
                var evento = Evento.builder()
                        .allDay(false)
                        .title(p.getProcedimento().concat(" - ").concat(p.getNome()))
                        .start(ultimoAgendamento)
                        .end(ultimoAgendamento.plusMinutes(15L))
                        .backgroundColor(colorEventoService.getColorByProcedimento(p.getProcedimento()))
                        .confirmado(false)
                        .aquisicaoProcedimento(p)
                    .build();

                super.create(evento);
            }
        }
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