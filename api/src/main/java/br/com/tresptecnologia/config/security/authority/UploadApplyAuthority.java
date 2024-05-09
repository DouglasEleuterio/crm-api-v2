package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.service.auth.authority.UploadAuthority;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class UploadApplyAuthority implements ApplyAuthority {

    private UploadApplyAuthority() {
    }

    public void configure(final HttpSecurity http) throws DomainException {
        try {
            final var path = "/upload";
            // @formatter:off
            http.authorizeHttpRequests()
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(UploadAuthority.SEARCH)
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(UploadAuthority.FETCH)
                    .requestMatchers(HttpMethod.POST, path)
                        .hasAnyAuthority(UploadAuthority.CREATE)
                    .requestMatchers(HttpMethod.DELETE, path + "/**")
                        .hasAnyAuthority(UploadAuthority.DELETE);
            // @formatter:on
        } catch (Exception ex) {
            throw new DomainException(ex);
        }
    }

}
