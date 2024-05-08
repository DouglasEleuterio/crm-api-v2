package br.com.tresptecnologia.core.exception;

import br.com.tresptecnologia.core.message.Message;
import lombok.Getter;

public class AuthorityException extends DomainException {

    @Getter
    private final String[] authorities;

    public AuthorityException(String[] authorities) {
        super(Message.toLocale("error.forbidden"));
        this.authorities = authorities;
    }

    public AuthorityException(String message) {
        super(Message.toLocale(message));
        this.authorities = new String[0];
    }

    public AuthorityException(String message, String[] authorities) {
        super(Message.toLocale(message));
        this.authorities = authorities;
    }

}
