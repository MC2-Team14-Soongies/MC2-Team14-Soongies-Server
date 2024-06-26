package com.appledeveloperacademy.soongies.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "google")
@Getter
@Setter
public class GoogleConfig {

    private String apiKey;
    private String clientId;
    private String clientSecret;
    private String grantType;
}
