package br.com.tresptecnologia.core.audit.reader;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.exception.AuditException;
import org.hibernate.service.ServiceRegistry;

public final class AuditReaderFactory {

    private AuditReaderFactory() {
    }

	public static AuditReader get(EntityManager entityManager) throws AuditException {
		if (entityManager.getDelegate() instanceof Session session) {
			return get(session);
		} else if (entityManager.getDelegate() instanceof EntityManager object) {
			return get(object);
		} else {
			throw new AuditException("Hibernate EntityManager not present!");
		}
	}

	public static AuditReader get(Session session) throws AuditException {
		SessionImplementor sessionImpl;

		if (!(session instanceof SessionImplementor sessionImplementor)) {
			sessionImpl = (SessionImplementor) session.getSessionFactory().getCurrentSession();
		} else {
			sessionImpl = sessionImplementor;
		}

		final ServiceRegistry serviceRegistry = sessionImpl.getFactory().getServiceRegistry();
		final EnversService enversService = serviceRegistry.getService(EnversService.class);
		return new AuditCustomReader(enversService, session, sessionImpl);
	}
}
