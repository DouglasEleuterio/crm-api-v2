package br.com.tresptecnologia.core.email.impl;

import br.com.tresptecnologia.core.email.EmailAttachment;
import br.com.tresptecnologia.core.email.IEmailService;
import br.com.tresptecnologia.core.email.exception.EmailException;
import br.com.tresptecnologia.core.email.EmailEvent;
import br.com.tresptecnologia.core.email.IEmailHtmlParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Slf4j
public class EmailService implements IEmailService {

    private final IEmailHtmlParserService htmlParserService;
    private final JavaMailSender javaMailSender;

    public EmailService(final IEmailHtmlParserService htmlParserService,
                        final JavaMailSender javaMailSender) {
        this.htmlParserService = htmlParserService;
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmailAsync(final EmailEvent emailEvent) throws EmailException {
        sendEmail(emailEvent);
    }

    public void sendEmailSync(final EmailEvent emailEvent) throws EmailException {
        sendEmail(emailEvent);
    }

    private void sendEmail(final EmailEvent emailEvent) throws EmailException {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(emailEvent.getSubject());
            helper.setTo(emailEvent.getToArray());
            helper.setFrom(emailEvent.getFrom());
            String emailContent = htmlParserService.parse(emailEvent);
            helper.setText(emailContent, true);

            buildAttachments(helper, emailEvent);

            javaMailSender.send(mimeMessage);
        } catch (EmailException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EmailException("Falha ao enviar o e-mail", ex);
        }
    }

    private void buildAttachments(@NonNull final MimeMessageHelper helper,
                                  @NonNull final EmailEvent emailEvent) throws MessagingException {
        if (emailEvent.getAttachments() != null && !emailEvent.getAttachments().isEmpty()) {
            for (EmailAttachment attachment : emailEvent.getAttachments()) {
                helper.addAttachment(attachment.getName(), attachment::getInputStream);
            }
        }
    }

}
