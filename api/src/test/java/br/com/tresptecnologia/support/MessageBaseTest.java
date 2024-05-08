package br.com.tresptecnologia.support;

import org.springframework.context.support.ResourceBundleMessageSource;

public abstract class MessageBaseTest {

    protected static ResourceBundleMessageSource newResourceBundleMessageSource() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.addBasenames("messages");
        messageSource.setBasename("messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}
