package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.auth.AuthLogout;
import br.com.tresptecnologia.model.auth.AuthRequest;
import br.com.tresptecnologia.model.auth.AuthUser;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IOAuthService {

    AuthUser token(AuthRequest authRequest) throws DomainException, JsonProcessingException;

    AuthLogout logout(String refreshToken, String redirectUri) throws DomainException;

}
