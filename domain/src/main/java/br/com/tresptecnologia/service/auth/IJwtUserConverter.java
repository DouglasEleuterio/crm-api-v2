package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.model.auth.AuthUser;
import br.com.tresptecnologia.model.auth.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public interface IJwtUserConverter {
    AuthUser user(OAuthToken authToken) throws JsonProcessingException;

    Collection<String> permissions(Map<String, Object> claims);

    Collection<GrantedAuthority> jwtAuthorities(Map<String, Object> claims);
}
