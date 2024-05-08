package br.com.tresptecnologia.core.config;

import br.com.tresptecnologia.model.auth.AuthConfig;
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

    /**
     * Ambiente da aplicação.
     */
    private String env;

    /**
     * Nome da aplicação.
     */
    private String name;

    /**
     * Versão da aplicação.
     */
    private String version;

    /**
     * Descrição da aplicação
     */
    private String description;

    /**
     * Url da api.
     */
    private String apiUrl;

    /**
     * Nome da aplicação padrão
     */
    private String defaultAppName;

    /**
     * Exibir stacktrace quando ocorrer um erro não mapeado.
     */
    private boolean exibirStacktrace;

    /**
     * Exibir permissão necessária quando ocorrer erro de não autorizado.
     */
    private boolean exibirAutorizacao;

    /**
     * Ignorar a aplicação de autorizações.
     */
    private boolean ignorarAutorizacao;

    /**
     * Diretorio base de relatorios
     * @return
     */
    private String resourceReportFolder;

    private String corsOrigin;

    private boolean debugEmail;

    @NestedConfigurationProperty
    private AuthConfig auth;

    public boolean isDev() {
        return "dev".equalsIgnoreCase(env);
    }

}
