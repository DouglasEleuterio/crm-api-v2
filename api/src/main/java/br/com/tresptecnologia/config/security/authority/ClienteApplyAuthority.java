package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.service.auth.authority.ClienteAuthority;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class ClienteApplyAuthority implements ApplyAuthority {

    private ClienteApplyAuthority() {
    }

    public void configure(final HttpSecurity http) throws DomainException {
        try {
            final var path = "/cliente";
            // @formatter:off
            http.authorizeHttpRequests()
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(ClienteAuthority.SEARCH)
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(ClienteAuthority.FETCH)
                    .requestMatchers(HttpMethod.POST, path)
                        .hasAnyAuthority(ClienteAuthority.CREATE)
                    .requestMatchers(HttpMethod.DELETE, path + "/**")
                        .hasAnyAuthority(ClienteAuthority.DELETE);
            // @formatter:on
        } catch (Exception ex) {
            throw new DomainException(ex);
        }
    }

}
