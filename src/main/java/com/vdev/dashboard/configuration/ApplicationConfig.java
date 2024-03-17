package com.vdev.dashboard.configuration;

import lombok.Data;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "app.rest.youtube")
@Data
@ToString
public class ApplicationConfig {
    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
    private String channel;
    private String secretApi;
    private String requestUrl;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}