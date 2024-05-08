package br.com.tresptecnologia.config.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties(value = CacheConfigProperties.class)
public class CacheConfig {

    private final CacheConfigProperties cacheConfigProperties;

    public CacheConfig(final CacheConfigProperties cacheConfigProperties) {
        this.cacheConfigProperties = cacheConfigProperties;
    }

    @Bean
    public CacheManager cacheManager() {
        final List<CacheConfigProperties.Cache> stores = cacheConfigProperties.getStores();
        final CaffeineCacheManager manager = new CaffeineCacheManager();
        stores.forEach(x -> manager.registerCustomCache(x.getName(),
                Caffeine.newBuilder()
                        .expireAfterWrite(x.getExpiryInMinutes(), TimeUnit.MINUTES)
                        .build()));
        return manager;

    }
}
