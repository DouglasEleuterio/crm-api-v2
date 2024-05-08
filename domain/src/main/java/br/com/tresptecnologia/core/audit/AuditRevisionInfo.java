package br.com.tresptecnologia.core.audit;

import br.com.tresptecnologia.core.audit.model.AuditRevisionUserInfo;

public final class AuditRevisionInfo {

	private static IAuditRevisionInfo context;

	private AuditRevisionInfo() {
	}

	public static void setAuditRevisionInfoService(IAuditRevisionInfo auditRevisionInfo) {
		AuditRevisionInfo.context = auditRevisionInfo;
	}

	public static AuditRevisionUserInfo obterInfo() {
		return context.getRevisionUserInfo();
	}
}
