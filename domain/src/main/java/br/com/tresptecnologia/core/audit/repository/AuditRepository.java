package br.com.tresptecnologia.core.audit.repository;

import br.com.tresptecnologia.entity.AuditRevision;
import br.com.tresptecnologia.core.audit.reader.AuditReaderFactory;
import br.com.tresptecnologia.core.audit.mapper.RevisionMapper;
import br.com.tresptecnologia.core.audit.model.EntityRevision;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class AuditRepository implements RevisionRepository {

    private final EntityManager entityManager;

    public AuditRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public <T, I, R> List<EntityRevision<R>> findRevisions(I id, LocalDate start, LocalDate end,
                                                           RevisionMapper<R> mapper, Class<T> type) {
        try {
            var reader = AuditReaderFactory.get(entityManager);
            var auditQuery = reader.createQuery()
                    .forRevisionsOfEntityWithChanges(type, true)
                    .addOrder(AuditEntity.revisionNumber().desc())
                    .add(AuditEntity.id().eq(id));

            if (start != null) {
                auditQuery.add(AuditEntity.revisionProperty("revisionDate")
                        .ge(start));
            }

            if (end != null) {
                auditQuery.add(AuditEntity.revisionProperty("revisionDate")
                        .le(end));
            }

            List<Object[]> resultList = auditQuery.getResultList();

            return resultList.stream().map(x -> convertRevision(x, mapper))
                    .toList();
        } catch (Exception ex) {
            log.error("Falha ao realizar a consulta dos dados de auditoria", ex);
        }
        return Collections.emptyList();
    }

    private <R> EntityRevision<R> convertRevision(Object[] data, RevisionMapper<R> revisionMapper) {
        var revisionEntity = (AuditRevision) data[1];

        var revision = new EntityRevision<R>();
        revision.setId(revisionEntity.getId());
        revision.setUserid(revisionEntity.getUserId());
        revision.setUsername(revisionEntity.getUserName());
        revision.setRevisionDate(revisionEntity.getRevisionDate());

        Hibernate.initialize(data[0]);

        revision.setEntity(revisionMapper.mapper(data[0]));
        revision.setRevisionType((RevisionType) data[2]);
        return revision;
    }

}
