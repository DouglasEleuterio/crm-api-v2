package br.com.tresptecnologia.core.email.impl;

import br.com.tresptecnologia.core.email.IEmailService;
import br.com.tresptecnologia.core.email.exception.EmailException;
import br.com.tresptecnologia.core.email.EmailEvent;
import br.com.tresptecnologia.core.email.IEmailHtmlParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

@Slf4j
public class DebugEmailService implements IEmailService {

    private final IEmailHtmlParserService parserService;

    public DebugEmailService(IEmailHtmlParserService parserService) {
        this.parserService = parserService;
    }

    @Override
    public void sendEmailAsync(@NonNull final EmailEvent emailEvent) throws EmailException {

        log.info(emailEvent.toPrintTable(parserService.parse(emailEvent)));
    }

    @Override
    public void sendEmailSync(@NonNull final EmailEvent emailEvent) throws EmailException {
        log.info(emailEvent.toPrintTable(parserService.parse(emailEvent)));
    }
}
