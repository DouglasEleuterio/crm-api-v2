package br.com.tresptecnologia.service.auth.logout;

import br.com.tresptecnologia.model.auth.AuthConfig;
import br.com.tresptecnologia.model.auth.AuthLogout;
import br.com.tresptecnologia.model.auth.OAuthToken;
import br.com.tresptecnologia.service.auth.constants.OAuthConstants;
import br.com.tresptecnologia.service.auth.IOAuthLogoutStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class OAuthLogoutKeycloakStrategy implements IOAuthLogoutStrategy {

    private final RestTemplate restTemplate;
    private final AuthConfig authConfig;

    public OAuthLogoutKeycloakStrategy(final RestTemplate restTemplate,
                                       final AuthConfig authConfig) {
        this.restTemplate = restTemplate;
        this.authConfig = authConfig;
    }

    @Override
    public AuthLogout logout(final String refreshToken,
                             final String redirectUri) {
        try {
            final var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            final var form = new LinkedMultiValueMap<String, String>();
            form.add(OAuthConstants.CLIENT_ID, authConfig.clientId());
            form.add(OAuthConstants.CLIENT_SECRET, authConfig.clientSecret());
            form.add("redirect_uri", authConfig.redirectUri());
            form.add("refresh_token", refreshToken);

            var entityRequest = new HttpEntity<MultiValueMap<String, String>>(form, headers);

            restTemplate.exchange(authConfig.logoutUrl(),
                    HttpMethod.POST, entityRequest, OAuthToken.class);

        } catch (HttpClientErrorException ex) {
            log.debug(String.format("Falha ao realizar o logout. Código de retorno: '%s' e resposta: '%s'",
                    ex.getStatusCode(), ex.getResponseBodyAsString()), ex);
        }

        return new AuthLogout(String.format("%s?redirect_uri=%s", authConfig.redirectLogoutUrl(), redirectUri), true);
    }
}
