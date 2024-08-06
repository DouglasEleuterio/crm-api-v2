package br.com.tresptecnologia.service.regiao;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.entity.procedimento.Regiao;

public interface IRegiaoService {

    Regiao findById(Long id) throws DomainException;
}
