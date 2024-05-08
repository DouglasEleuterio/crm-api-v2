package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.auth.OAuthToken;

public interface IClientCredentialsTokenStorage {
    OAuthToken getToken() throws DomainException;
}
