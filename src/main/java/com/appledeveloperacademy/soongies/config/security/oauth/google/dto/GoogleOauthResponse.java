package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

public class GoogleOauthResponse {

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthDeviceCodeResponse {
        private String deviceCode;
        private String userCode;
        private int expiresIn;
        private int interval;
        private String verificationUrl;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleOauthTokenResponse {
        private String accessToken;
        private Long expiresIn;
        private String refreshToken;
        private String scope;
        private String tokenType;
    }
}
