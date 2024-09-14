package br.com.tresptecnologia.service.atendimento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.atendimento.Atendimento;
import br.com.tresptecnologia.model.atendimento.AtendimentoRequest;
import br.com.tresptecnologia.model.atendimento.AtendimentoResponse;

import java.util.function.Function;

public interface IAtendimentoService extends IBaseActiveService<Atendimento>, IBaseFetchMapperService<Atendimento> {

    AtendimentoResponse inserirAtendimento(AtendimentoRequest atendimento, Function<Atendimento, AtendimentoResponse> converter) throws DomainException;
}
