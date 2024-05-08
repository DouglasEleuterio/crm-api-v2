package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.service.auth.authority.ExemploAuthority;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class VendasApplyAuthority implements ApplyAuthority {

    private VendasApplyAuthority() {
    }

    public void configure(final HttpSecurity http) throws DomainException {
        try {
            final var path = "/vendas";
            http.authorizeHttpRequests().requestMatchers(path + "/**").permitAll();
            http.authorizeHttpRequests().requestMatchers(path ).permitAll();
        } catch (Exception ex) {
            throw new DomainException(ex);
        }
    }

}
