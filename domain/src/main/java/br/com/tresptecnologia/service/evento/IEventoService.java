package br.com.tresptecnologia.service.evento;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.aquisicao.Aquisicao;
import br.com.tresptecnologia.entity.evento.Evento;

public interface IEventoService extends IBaseActiveService<Evento>, IBaseFetchMapperService<Evento> {

    void create(Aquisicao aquisicao) throws DomainException;
}
