package br.com.tresptecnologia.service.audit;

import br.com.tresptecnologia.core.audit.AuditRevisionInfo;
import br.com.tresptecnologia.core.audit.IAuditRevisionInfo;
import br.com.tresptecnologia.core.audit.model.AuditRevisionUserInfo;
import br.com.tresptecnologia.core.config.ApplicationProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;

//TODO: Aplicar um esquema generico que não faça referencia a auditoria.
@Service
public class AuditRevisionInfoService implements IAuditRevisionInfo {

    private final ApplicationProperties applicationProperties;

    public AuditRevisionInfoService(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        AuditRevisionInfo.setAuditRevisionInfoService(this);
    }

    @Override
    public AuditRevisionUserInfo getRevisionUserInfo() {
        final var info = new AuditRevisionUserInfo();
        final var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.isNull(authentication)) {
            info.setUserName(applicationProperties.getDefaultAppName());
        } else {

            if (authentication.getPrincipal() instanceof Jwt jwt) {
                info.setUserId(jwt.getClaimAsString("sub"));
                info.setUserName(jwt.getClaimAsString("preferred_username"));
            } else {
                info.setUserName(applicationProperties.getDefaultAppName());
            }

            if (authentication.getDetails() instanceof WebAuthenticationDetails details) {
                info.setUserIp(details.getRemoteAddress());
            }
        }

        return info;
    }
}
