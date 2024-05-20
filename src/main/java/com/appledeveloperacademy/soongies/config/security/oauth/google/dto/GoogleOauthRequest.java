package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

public class GoogleOauthRequest {

    @Data
//    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GoogleDeviceCodeRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("scope")
        private String scope;
    }
}
