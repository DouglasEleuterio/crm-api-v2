package br.com.tresptecnologia.core.controller.model;

import br.com.tresptecnologia.core.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthorityResponse {
    private int status;
    private String message;
    private String[] authorities;

    public static AuthorityResponse withoutPermission() {
        return AuthorityResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(Message.toLocale("error.forbidden"))
                .build();
    }

    public static AuthorityResponse withoutPermission(String message) {
        return AuthorityResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(message)
                .build();
    }

    public static AuthorityResponse withoutPermission(String message, String[] authorities) {
        return AuthorityResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(message)
                .authorities(authorities)
                .build();
    }

    public static AuthorityResponse withoutPermission(String[] authorities) {
        return AuthorityResponse.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .message(Message.toLocale("error.forbidden"))
                .authorities(authorities)
                .build();
    }

}
