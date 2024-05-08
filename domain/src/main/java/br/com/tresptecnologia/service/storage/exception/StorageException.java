package br.com.tresptecnologia.service.storage.exception;


import br.com.tresptecnologia.core.exception.DomainException;

public class StorageException extends DomainException {
    public StorageException(String s) {
        super(s);
    }
}
