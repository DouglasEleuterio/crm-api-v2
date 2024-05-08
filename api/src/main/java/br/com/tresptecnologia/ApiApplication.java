package br.com.tresptecnologia;

import br.com.tresptecnologia.core.repository.RsqlRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@EnableScheduling
@EntityScan("br.com.tresptecnologia.entity")
@ConfigurationPropertiesScan(basePackages = "br.com.tresptecnologia")
@SpringBootApplication(scanBasePackages = "br.com.tresptecnologia")
@EnableJpaRepositories(basePackages = "br.com.tresptecnologia",
        repositoryBaseClass = RsqlRepository.class
)
public class ApiApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("ApiLookup-");
        executor.initialize();
        return executor;
    }
}
