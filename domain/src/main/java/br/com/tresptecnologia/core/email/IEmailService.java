package br.com.tresptecnologia.core.email;

import br.com.tresptecnologia.core.email.exception.EmailException;

public interface IEmailService {
    void sendEmailAsync(final EmailEvent emailEvent)
            throws EmailException;

    void sendEmailSync(final EmailEvent emailEvent) throws EmailException;
}
