package br.com.tresptecnologia.core.exception;

import br.com.tresptecnologia.core.message.Message;

public class LoginException extends DomainException {
    public LoginException() {
        super(Message.toLocale("auth.notfound"));
    }
}
