package br.com.tresptecnologia.core.message.locale;

import br.com.tresptecnologia.core.config.ApplicationProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validation;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver
        implements WebMvcConfigurer {

    private final ApplicationProperties properties;

    List<Locale> locales = Collections.singletonList(new Locale("en"));

    public CustomLocaleResolver(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        return headerLang == null || headerLang.isEmpty() ? Locale.getDefault() :
                Locale.lookup(Locale.LanguageRange.parse(headerLang), locales);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("messages");
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }

    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setMessageInterpolator(new CustomValidationMessageInterpolator(Validation.byDefaultProvider().configure().getDefaultMessageInterpolator(), messageSource()));
        return bean;
    }

    public static MessageInterpolator buildMessageInterpolator(MessageSource messageSource) {
        return new ResourceBundleMessageInterpolator(new MessageSourceResourceBundleLocator(messageSource));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(properties.getCorsOrigin())
                .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE)
                .allowedMethods(
                        HttpMethod.DELETE.name(),
                        HttpMethod.OPTIONS.name(),
                        HttpMethod.HEAD.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.TRACE.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.GET.name(),
                        HttpMethod.PATCH.name());
    }
}
