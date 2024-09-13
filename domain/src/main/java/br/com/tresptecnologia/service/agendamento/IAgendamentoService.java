package br.com.tresptecnologia.service.agendamento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.agendamento.Agendamento;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.model.agendamento.AlterarAgendamentoRequest;

public interface IAgendamentoService extends IBaseActiveService<Agendamento>, IBaseFetchMapperService<Agendamento> {
    void create(Aquisicao aquisicao) throws DomainException;

    void cancelarAgendamento(Long id) throws DomainException;

    void confirmar(Long evento, AlterarAgendamentoRequest confirmacao) throws DomainException;
}
