package br.com.tresptecnologia.core.audit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditRevisionUserInfo {

	private String userId;
	private String userName;
	private String userIp;

}
