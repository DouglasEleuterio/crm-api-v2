package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface ApplyAuthority {

    void configure(final HttpSecurity http) throws DomainException;
}
