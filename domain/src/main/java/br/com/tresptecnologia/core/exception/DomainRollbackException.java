package br.com.tresptecnologia.core.exception;

public class DomainRollbackException extends RuntimeException {

    public DomainRollbackException(String s) {
        super(s);
    }

    public DomainRollbackException(String message, Throwable cause) {
        super(message, cause);
    }
}
