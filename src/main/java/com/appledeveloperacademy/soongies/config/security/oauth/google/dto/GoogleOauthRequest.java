package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

public class GoogleOauthRequest {

    @Data
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthDeviceCodeRequest {
        private String clientId;
        private String scope;
    }

    @Data
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthTokenRequest {
        private String clientId;
        private String clientSecret;
        private String code;
        private String grantType;
    }
}
