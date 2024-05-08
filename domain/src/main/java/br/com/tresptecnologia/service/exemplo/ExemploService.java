package br.com.tresptecnologia.service.exemplo;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.mapper.JsonMapper;
import br.com.tresptecnologia.core.repository.BaseRepository;
import br.com.tresptecnologia.core.service.BaseActiveService;
import br.com.tresptecnologia.entity.Exemplo;
import br.com.tresptecnologia.model.exemplo.ExemploResponse;
import br.com.tresptecnologia.repository.exemplo.ExemploRepository;
import br.com.tresptecnologia.service.exemplo.relacao.IExemploRelacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
public class ExemploService extends BaseActiveService<Exemplo> implements IExemploService {

    private final IExemploRelacaoService relacaoService;
    private final JsonMapper jsonMapper;

    protected ExemploService(final BaseRepository<Exemplo> repository,
                             final IExemploRelacaoService relacaoService,
                             final JsonMapper jsonMapper) {
        super(repository);
        this.relacaoService = relacaoService;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public Page<ExemploResponse> findAllJsonMapper(Specification<Exemplo> spec, Pageable pageable) {
        return fetch(spec, pageable, ExemploResponse.class);
    }

    @Override
    public void validate(final Exemplo entity) throws DomainException {
        super.validate(entity);
        if (entity.getRelacao() != null && Objects.nonNull(entity.getRelacao().getId())) {
            final var relacaoId = entity.getRelacao().getId();
            final var relacao = relacaoService.findById(relacaoId);
            entity.setRelacao(relacao);
        }
    }

    @Override
    public Exemplo atualizarNome(final Long exemploId, final Exemplo entity) throws DomainException {
        var exemplo = this.findById(exemploId);
        exemplo.setNome(entity.getNome());
        return getRepository().save(exemplo);
    }

    @Override
    public ExemploRepository getRepository() {
        return (ExemploRepository) super.getRepository();
    }

    @Override
    public JsonMapper getJsonMapper() {
        return jsonMapper;
    }

}
