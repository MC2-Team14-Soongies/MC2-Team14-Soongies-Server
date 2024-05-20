package com.appledeveloperacademy.soongies.config.security.oauth.google.client;

import com.appledeveloperacademy.soongies.config.FeignConfig;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "googleOauthClient",
        url = "https://oauth2.googleapis.com",
        configuration = FeignConfig.class
)
public interface GoogleClient {

    @PostMapping(value = "/device/code")
    public GoogleOauthResponse.GoogleOauthDeviceCodeResponse getDeviceInfo(
            @RequestBody GoogleOauthRequest.GoogleOauthDeviceCodeRequest request
            );

    @PostMapping(value = "/token")
    public GoogleOauthResponse.GoogleOauthTokenResponse getTokenInfo(
            @RequestBody GoogleOauthRequest.GoogleOauthTokenRequest request
            );
}
