package br.com.tresptecnologia.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PathRelatorioResolver implements IPathRelatorioResolver {

    private final ApplicationProperties applicationProperties;

    @Override
    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }

}
