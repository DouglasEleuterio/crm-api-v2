package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.service.auth.authority.ExemploAuthority;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class ExemploApplyAuthority implements ApplyAuthority {

    private ExemploApplyAuthority() {
    }

    public void configure(final HttpSecurity http) throws DomainException {
        try {
            final var path = "/exemplos";
            // @formatter:off
            http.authorizeHttpRequests()
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(ExemploAuthority.SEARCH)
                    .requestMatchers(HttpMethod.GET, path + "/**")
                        .hasAnyAuthority(ExemploAuthority.FETCH)
                    .requestMatchers(HttpMethod.POST, path)
                        .hasAnyAuthority(ExemploAuthority.CREATE)
                    .requestMatchers(HttpMethod.PUT, path + "/**")
                        .hasAnyAuthority(ExemploAuthority.UPDATE)
                    .requestMatchers(HttpMethod.DELETE, path + "/**")
                        .hasAnyAuthority(ExemploAuthority.DELETE);
            // @formatter:on
        } catch (Exception ex) {
            throw new DomainException(ex);
        }
    }

}
