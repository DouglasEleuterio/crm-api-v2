package br.com.tresptecnologia.config.cache;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "caches")
public class CacheConfigProperties {

    private List<Cache> stores;

    @Getter
    @Setter
    public static class Cache {

        private String name;

        private Long expiryInMinutes;
    }

}
