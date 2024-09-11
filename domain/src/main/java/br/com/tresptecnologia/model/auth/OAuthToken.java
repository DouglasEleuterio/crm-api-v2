package br.com.tresptecnologia.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private long expireIn;

    @JsonProperty("refresh_expires_in")
    private long refreshExpireIn;

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
