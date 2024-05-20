package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

public class GoogleOauthResponse {

    @Getter
    @Builder
//    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleDeviceCodeResponse {
        private String device_code;
        private String user_code;
        private int expires_in;
        private int interval;
        private String verification_url;
    }
}
