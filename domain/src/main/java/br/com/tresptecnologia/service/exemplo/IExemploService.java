package br.com.tresptecnologia.service.exemplo;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.service.IBaseActiveService;
import br.com.tresptecnologia.core.service.IBaseFetchMapperService;
import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.model.exemplo.ExemploResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IExemploService extends IBaseActiveService<Exemplo>,
        IBaseFetchMapperService<Exemplo> {

    Exemplo atualizarNome(Long exemploId, Exemplo entity) throws DomainException;

    Page<ExemploResponse> findAllJsonMapper(Specification<Exemplo> spec, Pageable pageable);
}
