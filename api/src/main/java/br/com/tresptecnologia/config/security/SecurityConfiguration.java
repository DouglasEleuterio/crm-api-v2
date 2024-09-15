package br.com.tresptecnologia.config.security;

import br.com.tresptecnologia.config.security.authority.ApplyAuthority;
import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.security.BaseAccessDeniedHandler;
import br.com.tresptecnologia.service.auth.IJwtUserConverter;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final ApplicationProperties properties;
    private final ListableBeanFactory beanFactory;

    private final IJwtUserConverter jwtUserConverter;

    private final BaseAccessDeniedHandler baseAccessDeniedHandler;

    public SecurityConfiguration(final ApplicationProperties properties,
                                 final ListableBeanFactory beanFactory,
                                 final IJwtUserConverter jwtUserConverter,
                                 final BaseAccessDeniedHandler baseAccessDeniedHandler) {
        this.properties = properties;
        this.beanFactory = beanFactory;
        this.jwtUserConverter = jwtUserConverter;
        this.baseAccessDeniedHandler = baseAccessDeniedHandler;
    }

    // @formatter:off
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

        if (properties.isHabilitarAutorizacao()) {
            final Collection<ApplyAuthority> interfaces = beanFactory.getBeansOfType(ApplyAuthority.class)
                    .values();
            for (final ApplyAuthority applyAuthority : interfaces) {
                applyAuthority.configure(http);
            }
            http.authorizeHttpRequests().anyRequest().authenticated();
        } else {
            http.authorizeHttpRequests().anyRequest().permitAll();
        }

        http.authorizeHttpRequests()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .exceptionHandling()
                .accessDeniedHandler(baseAccessDeniedHandler);
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt ->
                jwtUserConverter.jwtAuthorities(jwt.getClaims()));
        return jwtAuthenticationConverter;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Collections.singletonList(properties.getCorsOrigin()));
        config.addAllowedHeader(HttpHeaders.AUTHORIZATION);
        config.addAllowedHeader(HttpHeaders.CONTENT_TYPE);
        config.addExposedHeader(HttpHeaders.CONTENT_DISPOSITION);
        config.addExposedHeader(HttpHeaders.CONTENT_ENCODING);
        config.addExposedHeader("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.HEAD);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.TRACE);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.PATCH);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
