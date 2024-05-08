package br.com.tresptecnologia.model.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
public class AuthUser extends OAuthToken {
    private String id;
    private String name;
    private String email;
    private Collection<String> permissions;
    private Collection<String> roles;

    public static AuthUser createFromJwtToken(OAuthToken oAuthToken, Map<String, Object> claimsMap) throws JsonProcessingException {
        final var user = new AuthUser();
        final var claims = JwtClaims.fromMap(claimsMap);
        user.setId(claims.getSub());
        user.setName(claims.getName());
        user.setEmail(claims.getEmail());
        user.setAccessToken(oAuthToken.getAccessToken());
        user.setRefreshToken(oAuthToken.getRefreshToken());
        user.setExpireIn(oAuthToken.getExpireIn());
        user.setJti(oAuthToken.getJti());
        user.setScope(oAuthToken.getScope());
        user.setTokenType(oAuthToken.getTokenType());
        return user;
    }
}
