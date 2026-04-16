package io.github.yury_developer.hh.starter.autoconfigure.config;

import io.github.yury_developer.hh.starter.autoconfigure.client.HhApiClient;
import io.github.yury_developer.hh.starter.autoconfigure.client.impl.HhApiClientImpl;
import io.github.yury_developer.hh.starter.autoconfigure.properties.HhProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HhApiClient.class)
@EnableConfigurationProperties(HhProperties.class)
@ConditionalOnProperty(prefix = "hh.api", name = "enabled", havingValue = "true", matchIfMissing = true)
public class HhAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HhApiClient hhApiClient(HhProperties properties) {
        return new HhApiClientImpl(properties);
    }
}
