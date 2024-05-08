package br.com.tresptecnologia.config.security.authority;

import br.com.tresptecnologia.core.exception.DomainException;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;

@Component
public class PublicsApplyAuthority implements ApplyAuthority {
    @Override
    public void configure(HttpSecurity http) throws DomainException {
        try {
            // @formatter:off
            http
                    .cors()
                    .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .ignoringRequestMatchers("/auth/**");
            http.authorizeHttpRequests()
                    .requestMatchers(CorsUtils::isPreFlightRequest)
                        .permitAll()
                    .requestMatchers("/public/**")
                        .permitAll()
                    .requestMatchers("/auth/**")
                        .permitAll()
                    .requestMatchers("/actuator/**")
                        .permitAll()
                    .requestMatchers("/v3/api-docs")
                        .permitAll()
                    .requestMatchers("/v3/api-docs/**")
                        .permitAll()
                    .requestMatchers("/swagger-ui.html")
                        .permitAll()
                    .requestMatchers("/swagger-ui/**")
                        .permitAll()
                    .requestMatchers("/webjars/**")
                        .permitAll()
                    .requestMatchers("/swagger-resources/**")
                        .permitAll()
                    .requestMatchers(HttpMethod.OPTIONS, "/**")
                        .permitAll();
        } catch (Exception e) {
            throw new DomainException(e);
        }
    }
}
