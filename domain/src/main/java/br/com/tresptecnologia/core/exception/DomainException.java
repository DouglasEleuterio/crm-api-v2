package br.com.tresptecnologia.core.exception;

public class DomainException extends Exception {
    public DomainException(String s) {
        super(s);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainException(Throwable cause) {
        super(cause);
    }
}
