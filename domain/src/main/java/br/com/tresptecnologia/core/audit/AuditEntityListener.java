package br.com.tresptecnologia.core.audit;

import br.com.tresptecnologia.entity.AuditRevision;
import org.hibernate.envers.RevisionListener;

import java.util.Date;

public class AuditEntityListener implements RevisionListener {
	public void newRevision(Object obj) {
		AuditRevision revision = (AuditRevision) obj;
		revision.setRevisionDate(new Date());
		var userInfo = AuditRevisionInfo.obterInfo();
		revision.setUserId(userInfo.getUserId());
		revision.setUserName(userInfo.getUserName());
		revision.setUserIp(userInfo.getUserIp());
	}

}
