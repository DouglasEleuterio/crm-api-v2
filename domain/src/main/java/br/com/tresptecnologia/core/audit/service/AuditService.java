package br.com.tresptecnologia.core.audit.service;

import br.com.tresptecnologia.core.audit.repository.RevisionRepository;
import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.audit.mapper.RevisionMapper;
import br.com.tresptecnologia.core.audit.model.EntityRevision;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuditService implements IBaseAuditService {

	private final RevisionRepository auditRepository;

	public AuditService(RevisionRepository auditRepository) {
		this.auditRepository = auditRepository;
	}

	@Override
	public <T extends BaseEntity, R> List<EntityRevision<R>> find(long id, LocalDate start, LocalDate end,
                                                                  RevisionMapper<R> auditMapper, Class<T> clazz) {
		return auditRepository.findRevisions(id, start, end, auditMapper, clazz);
	}
}
