package br.com.tresptecnologia.core.exception;

import br.com.tresptecnologia.core.message.Message;

public class ConstraintException extends DomainException {
    public ConstraintException() {
        super(Message.toLocale("error.constraint"));
    }
}
