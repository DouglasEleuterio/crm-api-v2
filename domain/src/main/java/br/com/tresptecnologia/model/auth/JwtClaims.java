package br.com.tresptecnologia.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtClaims {

    private String sub;
    private String name;
    private String email;

    public static JwtClaims fromMap(Map<String, Object> claims) {
        return JwtClaims.builder()
                .sub((String) claims.get("sub"))
                .name((String) claims.get("name"))
                .email((String) claims.get("email"))
                .build();
    }

    public static Map<String, Object> getClaimsMap(String token) throws JsonProcessingException {
        var split = token.split("\\.");
        return new ObjectMapper()
                .readValue(new String(Base64.getDecoder().decode(split[1]), StandardCharsets.UTF_8),
                        Map.class);
    }

}
