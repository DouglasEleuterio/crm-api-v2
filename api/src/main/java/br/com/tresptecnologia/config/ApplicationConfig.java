package br.com.tresptecnologia.config;

import br.com.tresptecnologia.core.config.ApplicationProperties;
import br.com.tresptecnologia.core.controller.swagger.BaseResponseCustomizer;
import br.com.tresptecnologia.core.controller.swagger.SchemaStoreSingleton;
import br.com.tresptecnologia.core.email.IEmailService;
import br.com.tresptecnologia.core.email.impl.DebugEmailService;
import br.com.tresptecnologia.core.email.impl.EmailService;
import br.com.tresptecnologia.email.EmailHtmlParserService;
import br.com.tresptecnologia.service.auth.IOAuthLogoutStrategy;
import br.com.tresptecnologia.service.auth.logout.OAuthLogoutKeycloakStrategy;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Arrays;

@Configuration
public class ApplicationConfig {

    private final ApplicationProperties applicationProperties;
    private final BaseResponseCustomizer baseResponseCustomizer;

    private final SchemaStoreSingleton schemaStoreSingleton;

    public ApplicationConfig(final ApplicationProperties applicationProperties,
                             final BaseResponseCustomizer baseResponseCustomizer,
                             final SchemaStoreSingleton schemaStoreSingleton) {
        this.applicationProperties = applicationProperties;
        this.baseResponseCustomizer = baseResponseCustomizer;
        this.schemaStoreSingleton = schemaStoreSingleton;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url(applicationProperties.getApiUrl()))
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "bearer-jwt",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                                .in(SecurityScheme.In.HEADER)
                                                .name("Authorization")))
                .info(
                        new Info()
                                .title(applicationProperties.getName())
                                .version(applicationProperties.getEnv() + "-" + applicationProperties.getVersion())
                                .description(applicationProperties.getDescription()))
                .addSecurityItem(
                        new SecurityRequirement().addList("bearer-jwt", Arrays.asList("read", "write")));
    }

    @Bean
    public GroupedOpenApi appOpenApi() {
        return GroupedOpenApi.builder()
                .group("aplicação")
                .pathsToMatch("/**")
                .addOperationCustomizer(baseResponseCustomizer)
                .addOpenApiCustomizer(openAPI -> schemaStoreSingleton.getMapSchema().values().forEach(schema -> {
                    openAPI.schema(schema.schema.getName(), schema.schema);
                    if (!schema.referencedSchemas.isEmpty()) {
                        schema.referencedSchemas.values().forEach(x -> openAPI.schema(x.getName(), x));
                    }
                }))
                .build();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(9000))
                .setReadTimeout(Duration.ofMillis(90000))
                .build();
    }

    @Bean
    public IOAuthLogoutStrategy authLogoutStrategy(RestTemplate restTemplate) {
        return new OAuthLogoutKeycloakStrategy(restTemplate, applicationProperties.getAuth());
    }

    @Bean
    public IEmailService emailService(final JavaMailSender javaMailSender,
                                      final EmailHtmlParserService htmlParserService) {
        if (applicationProperties.isDebugEmail()) {
            return new DebugEmailService(htmlParserService);
        }

        return new EmailService(htmlParserService, javaMailSender);
    }

}
