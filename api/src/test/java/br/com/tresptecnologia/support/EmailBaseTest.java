package br.com.tresptecnologia.support;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Value;

import jakarta.mail.MessagingException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public abstract class EmailBaseTest extends BaseTest {

    @Value("${spring.mail.username}")
    protected String emailUser;

    @Value("${spring.mail.password}")
    protected String emailPassword;

    @Value("${spring.mail.host}")
    protected String emailHost;

    @Value("${spring.mail.port}")
    protected Integer emailPort;

    protected GreenMail smtpServer;

    protected final CountDownLatch waiter = new CountDownLatch(1);

    public void startEmailServer() {
        smtpServer = new GreenMail(new ServerSetup(emailPort, emailHost, "smtp"));
        smtpServer.setUser(emailUser, emailPassword);
        smtpServer.start();
    }

    public void stopEmailServer() {
        smtpServer.stop();
    }

    public String recoverInfoEmail(String elementId)
            throws IOException, MessagingException, javax.mail.MessagingException {
        final var receivedMessages = smtpServer.getReceivedMessages();
        Assertions.assertEquals(1, receivedMessages.length);
        final var content = (String) receivedMessages[0].getContent();
        final var html = Jsoup.parse(content);
        final var token = html.getElementById(elementId);
        return token != null ? token.text() : "";
    }

    public String recoverInfoEmail(String elementId, String property)
            throws IOException, MessagingException, javax.mail.MessagingException {
        final var receivedMessages = smtpServer.getReceivedMessages();
        Assertions.assertEquals(1, receivedMessages.length);
        final var content = (String) receivedMessages[0].getContent();
        final var html = Jsoup.parse(content);
        final var token = html.getElementById(elementId);
        return token != null ? token.attr(property) : "";

    }

}
