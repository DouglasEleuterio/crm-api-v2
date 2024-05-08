package br.com.tresptecnologia.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

public record AuthRequest(
        @JsonProperty("grant_type")
        @RequestParam("grant_type")
        AuthGrantType grantType,
        String code,
        String username,
        String password,
        @JsonProperty("refresh_token")
        @RequestParam("refresh_token")
        String refreshToken,
        @JsonProperty("redirect_uri")
        @RequestParam("redirect_uri")
        String redirectUri) {

    public static AuthRequest fromMultiValueMap(MultiValueMap<String, String> paramMap) {
        var grantType = AuthGrantType.valueOf(Objects.requireNonNull(paramMap.getFirst("grant_type"))
                .toUpperCase());
        return new AuthRequest(grantType,
                paramMap.getFirst("code"),
                paramMap.getFirst("username"),
                paramMap.getFirst("password"),
                paramMap.getFirst("refresh_token"),
                paramMap.getFirst("redirect_uri"));
    }
}
