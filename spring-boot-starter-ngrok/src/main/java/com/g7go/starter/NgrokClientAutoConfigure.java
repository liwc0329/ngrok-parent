package com.g7go.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr_Lee
 */
@Configuration
@ConditionalOnProperty(prefix = "ngrok", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(NgrokProperties.class)
public class NgrokClientAutoConfigure {

    @Bean
    public NgrokWebServerInitializedEventListener WebServerInitializedEventListener(NgrokProperties ngrokProperties) {
        return new NgrokWebServerInitializedEventListener(ngrokProperties);
    }
}
