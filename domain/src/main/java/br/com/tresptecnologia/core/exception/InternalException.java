package br.com.tresptecnologia.core.exception;

public class InternalException extends RuntimeException {
    public InternalException(String s) {
        super(s);
    }

    public InternalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalException(Throwable cause) {
        super(cause);
    }
}
