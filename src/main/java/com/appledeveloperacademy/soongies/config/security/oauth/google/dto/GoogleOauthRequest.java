package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

public class GoogleOauthRequest {

    @Data
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthDeviceCodeRequest {
        private String clientId;
        private String scope;
    }

    @Data
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthTokenRequest {
        @JsonProperty("client_id")
        private String clientId;
        @JsonProperty("client_secret")
        private String clientSecret;
        @JsonProperty("code")
        private String code;
        @JsonProperty("grant_type")
        private String grantType;
    }
}
