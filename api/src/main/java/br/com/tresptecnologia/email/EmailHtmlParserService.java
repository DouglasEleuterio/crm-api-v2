package br.com.tresptecnologia.email;

import br.com.tresptecnologia.core.email.EmailEvent;
import br.com.tresptecnologia.core.email.IEmailHtmlParserService;
import br.com.tresptecnologia.core.email.Templates;
import br.com.tresptecnologia.core.email.exception.EmailException;
import freemarker.template.Configuration;
import org.springframework.stereotype.Service;

import java.io.StringWriter;


/**
 * Implementação do parse de html utilizando o freemarker
 */
@Service
public class EmailHtmlParserService implements IEmailHtmlParserService {

    final Configuration configuration;

    public EmailHtmlParserService(final Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String parse(final EmailEvent emailEvent) throws EmailException {
        try {
            StringWriter stringWriter = new StringWriter();
            configuration.getTemplate(getTemplateLocation(emailEvent.getTemplate()))
                    .process(emailEvent.getParams(), stringWriter);
            return stringWriter.getBuffer().toString();
        } catch (Exception ex) {
            throw new EmailException(ex.getMessage(), ex);
        }
    }

    private String getTemplateLocation(final Templates template) {
        return switch (template) {
            case EMAIL_EXAMPLE -> "email/email-exemplo-template.ftlh";
            default -> throw new IllegalStateException("Unexpected value: " + template);
        };
    }

}
