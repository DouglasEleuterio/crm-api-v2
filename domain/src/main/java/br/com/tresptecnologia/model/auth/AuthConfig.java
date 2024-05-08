package br.com.tresptecnologia.model.auth;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

public record AuthConfig(
        String clientId,
        String clientSecret,
        String redirectUri,
        String tokenUrl,
        String logoutUrl,
        String redirectLogoutUrl,
        String userInfoUrl) {

    public String getBasicAuth() {
        return getBasicAuth(clientId, clientSecret);
    }

    private String getBasicAuth(String user, String password) {
        return Base64.getEncoder().encodeToString(String.format("%s:%s", user, password)
                .getBytes(StandardCharsets.UTF_8));
    }
}
