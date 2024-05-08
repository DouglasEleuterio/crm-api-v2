package br.com.tresptecnologia.core.email;

import br.com.tresptecnologia.core.email.exception.EmailException;

public interface IEmailHtmlParserService {
    String parse(final EmailEvent emailEvent) throws EmailException;
}
