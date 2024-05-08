package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.model.auth.OAuthToken;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@Scope("singleton")
public class ClientCredentialsTokenStorage implements IClientCredentialsTokenStorage {

    private OAuthToken token;

    private final OAuthService oAuthService;

    public ClientCredentialsTokenStorage(final OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @Synchronized
    public OAuthToken getToken() throws DomainException {
        if (Objects.isNull(this.token) || this.token.isExpired()) {
            this.token = oAuthService.authUsingClientCredentials();
        }
        return this.token;
    }
}
