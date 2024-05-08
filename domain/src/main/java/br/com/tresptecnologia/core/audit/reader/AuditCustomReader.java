package br.com.tresptecnologia.core.audit.reader;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.exception.AuditException;
import org.hibernate.envers.exception.NotAuditedException;
import org.hibernate.envers.internal.reader.AuditReaderImpl;
import org.hibernate.envers.internal.tools.EntityTools;
import org.hibernate.envers.query.AuditEntity;

import jakarta.persistence.NoResultException;

import static org.hibernate.envers.internal.tools.ArgumentsTools.checkNotNull;
import static org.hibernate.envers.internal.tools.ArgumentsTools.checkPositive;

public class AuditCustomReader extends AuditReaderImpl {

    public AuditCustomReader(final EnversService enversService,
                             final Session session,
                             final SessionImplementor sessionImplementor) {
        super(enversService, session, sessionImplementor);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T find(
            final Class<T> clazz,
            final String entityName,
            final Object primaryKey,
            final Number revision,
            boolean includeDeletions) throws IllegalArgumentException, NotAuditedException, IllegalStateException {

        Class<T> cls = EntityTools.getTargetClassIfProxied(clazz);

        checkNotNull(cls, "Entity class");
        checkNotNull(entityName, "Entity name");
        checkNotNull(primaryKey, "Primary key");
        checkNotNull(revision, "Entity revision");
        checkPositive(revision, "Entity revision");

        if (!this.getSession().isOpen()) {
            throw new IllegalStateException("The associated entity manager is closed!");
        }

        if (getFirstLevelCache().contains(entityName, revision, primaryKey)) {
            return (T) getFirstLevelCache().get(entityName, revision, primaryKey);
        }

        Object result;
        try {
            result = createQuery().forEntitiesAtRevision(cls, entityName, revision, includeDeletions)
                    .add(AuditEntity.id().eq(primaryKey)).getSingleResult();
        } catch (NoResultException e) {
            result = getSession().find(cls, primaryKey);
        } catch (NonUniqueResultException e) {
            throw new AuditException(e);
        }

        return (T) result;
    }
}
