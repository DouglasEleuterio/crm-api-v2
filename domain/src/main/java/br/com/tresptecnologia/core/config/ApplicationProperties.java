package br.com.tresptecnologia.core.config;

import br.com.tresptecnologia.model.auth.AuthConfig;
import br.com.tresptecnologia.model.upload.MiniIOProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String env;
    private String name;
    private String version;
    private String description;
    private String apiUrl;
    private String defaultAppName;
    private boolean exibirStacktrace;
    private boolean exibirAutorizacao;
    private boolean ignorarAutorizacao;
    private String resourceReportFolder;
    private String corsOrigin;
    private boolean debugEmail;
    private String minioUrl;
    private String minioAccessKey;
    private String minioSecretKey;
    private long tamanhoMaximoAnexo;
    @NestedConfigurationProperty
    private AuthConfig auth;
    @NestedConfigurationProperty
    private MiniIOProperties miniIOProperties;
    public boolean isDev() {
        return "dev".equalsIgnoreCase(env);
    }

}
