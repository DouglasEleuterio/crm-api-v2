package br.com.tresptecnologia.service.auth;

import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.message.Message;
import br.com.tresptecnologia.service.auth.constants.OAuthConstants;
import br.com.tresptecnologia.model.auth.AuthGrantType;
import br.com.tresptecnologia.model.auth.AuthUser;
import br.com.tresptecnologia.model.auth.OAuthToken;
import br.com.tresptecnologia.model.auth.AuthLogout;
import br.com.tresptecnologia.model.auth.AuthRequest;
import br.com.tresptecnologia.model.auth.AuthConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OAuthService implements IOAuthService {

    private final RestTemplate restTemplate;
    private final AuthConfig authConfig;

    private final IOAuthLogoutStrategy logoutStrategy;

    private final IJwtUserConverter jwtUserConverter;

    public OAuthService(final RestTemplate restTemplate,
                        final ApplicationProperties applicationProperties,
                        final IOAuthLogoutStrategy logoutStrategy,
                        final IJwtUserConverter jwtUserConverter) {
        this.restTemplate = restTemplate;
        this.authConfig = applicationProperties.getAuth();
        this.logoutStrategy = logoutStrategy;
        this.jwtUserConverter = jwtUserConverter;
    }

    @Override
    public AuthUser token(final AuthRequest authRequest) throws DomainException, JsonProcessingException {
        if (authRequest.grantType() == AuthGrantType.AUTHORIZATION_CODE) {
            if (authRequest.code() == null) {
                throw new DomainException(Message.toLocale("auth.invalid.code"));
            }

            return jwtUserConverter.user(authUsingCode(authRequest.redirectUri(), authRequest.code()));
        } else if (authRequest.grantType() == AuthGrantType.PASSWORD) {
            if (StringUtils.isBlank(authRequest.password()) ||
                    StringUtils.isBlank(authRequest.username())) {
                throw new DomainException(Message.toLocale("auth.invalid.credentials"));
            }

            return jwtUserConverter.user(authUsingPassword(authRequest.username(), authRequest.password()));
        } else if (authRequest.grantType() == AuthGrantType.REFRESH_TOKEN) {
            if (StringUtils.isBlank(authRequest.refreshToken())) {
                throw new DomainException(Message.toLocale("auth.invalid.credentials"));
            }

            return jwtUserConverter.user(authRefresh(authRequest.refreshToken()));
        }

        throw new DomainException(Message.toLocale("auth.invalid.request"));
    }

    private OAuthToken authUsingPassword(final String username, final String password) throws DomainException {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setBasicAuth(authConfig.clientId(), authConfig.clientSecret());

            final var form = new LinkedMultiValueMap<String, String>();
            form.add(OAuthConstants.CLIENT_ID, authConfig.clientId());
            form.add(OAuthConstants.CLIENT_SECRET, authConfig.clientSecret());
            form.add(OAuthConstants.GRANT_TYPE, "password");
            form.add("username", username);
            form.add("password", password);

            final var entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

            final var response =
                    restTemplate.exchange(authConfig.tokenUrl(), HttpMethod.POST, entity, OAuthToken.class);

            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.debug(String.format("Falha ao realizar o login. Código de retorno: '%s' e resposta: '%s'",
                    ex.getStatusCode(), ex.getResponseBodyAsString()), ex);
            throw new DomainException("Falha ao realizar o login", ex);
        }
    }

    private OAuthToken authRefresh(final String refresh) throws DomainException {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            final var form = new LinkedMultiValueMap<String, String>();
            form.add(OAuthConstants.CLIENT_ID, authConfig.clientId());
            form.add(OAuthConstants.CLIENT_SECRET, authConfig.clientSecret());
            form.add(OAuthConstants.GRANT_TYPE, AuthGrantType.REFRESH_TOKEN.name().toLowerCase());
            form.add("refresh_token", refresh);

            final var entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

            final var response = restTemplate.exchange(authConfig.tokenUrl(),
                    HttpMethod.POST, entity, OAuthToken.class);

            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.debug(String.format("Falha ao realizar ao realizar o refresh do token. Código de retorno: '%s' e resposta: '%s'",
                    ex.getStatusCode(), ex.getResponseBodyAsString()), ex);
            throw new DomainException("Falha ao realizar ao realizar o refresh do token", ex);
        }
    }

    private OAuthToken authUsingCode(final String redirectUri, final String code) throws DomainException {
        try {
            final var headers = new HttpHeaders();

            final var basicAuth = String.format("Basic %s", authConfig.getBasicAuth());

            headers.add("Authorization", basicAuth);
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            final var form = new LinkedMultiValueMap<String, String>();

            form.add(OAuthConstants.GRANT_TYPE, AuthGrantType.AUTHORIZATION_CODE.name().toLowerCase());
            form.add("redirect_uri", StringUtils.isBlank(redirectUri) ? authConfig.redirectUri() : redirectUri);
            form.add("code", code);

            var entityRequest = new HttpEntity<MultiValueMap<String, String>>(form, headers);
            var response = restTemplate.exchange(authConfig.tokenUrl(),
                    HttpMethod.POST, entityRequest, OAuthToken.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.error(String.format("Falha ao realizar a troca código pelo token. Código de retorno: '%s' e resposta: '%s'",
                    ex.getStatusCode(), ex.getResponseBodyAsString()), ex);
            throw new DomainException(String.format("Falha ao realizar a troca código pelo token\n\n %s", ex.getResponseBodyAsString()), ex);
        }
    }

    @Override
    public AuthLogout logout(final String refreshToken, final String redirectUri) {
        return logoutStrategy.logout(refreshToken, redirectUri);
    }

    public OAuthToken authUsingClientCredentials() throws DomainException {
        try {
            final var headers = new HttpHeaders();
            headers.add("Authorization", String.format("basic %s", authConfig.getBasicAuth()));

            final var form = new LinkedMultiValueMap<String, String>();
            form.add(OAuthConstants.CLIENT_ID, authConfig.clientId());
            form.add(OAuthConstants.CLIENT_SECRET, authConfig.clientSecret());
            form.add(OAuthConstants.GRANT_TYPE, AuthGrantType.CLIENT_CREDENTIALS.name().toLowerCase());

            final var entity = new HttpEntity<MultiValueMap<String, String>>(form, headers);

            final var response = restTemplate.exchange(authConfig.tokenUrl(),
                    HttpMethod.POST, entity, OAuthToken.class);

            return response.getBody();
        } catch (HttpClientErrorException ex) {
            log.debug(String.format("Falha ao realizar o refresh do token. Código de retorno: '%s' e resposta: '%s'",
                    ex.getStatusCode(), ex.getResponseBodyAsString()), ex);
            throw new DomainException("Falha ao realizar o refresh do token", ex);
        }
    }


}
