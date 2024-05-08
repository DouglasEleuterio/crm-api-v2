package br.com.tresptecnologia.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expire_in")
    private long expireIn;

    private String jti;

    @JsonProperty("refresh_token")
    private String refreshToken;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;

    public boolean isExpired(){
        return System.currentTimeMillis() > this.expireIn;
    }
}
