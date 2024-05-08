package br.com.tresptecnologia.core.audit.repository;

import br.com.tresptecnologia.core.audit.mapper.RevisionMapper;
import br.com.tresptecnologia.core.audit.model.EntityRevision;

import java.time.LocalDate;
import java.util.List;

public interface RevisionRepository {
	<T, I, R> List<EntityRevision<R>> findRevisions(I id,
													LocalDate start,
													LocalDate end,
													RevisionMapper<R> mapper,
													Class<T> type);

}
