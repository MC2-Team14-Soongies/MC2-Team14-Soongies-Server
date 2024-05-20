package com.appledeveloperacademy.soongies.config.security.oauth.google.client;

import com.appledeveloperacademy.soongies.config.FeignConfig;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        name = "googleOauthClient",
        url = "https://oauth2.googleapis.com",
        configuration = FeignConfig.class
)
public interface GoogleClient {

    @PostMapping(value = "/device/code")
    public GoogleOauthResponse.GoogleDeviceCodeResponse getUserCode(
            @RequestBody GoogleOauthRequest.GoogleDeviceCodeRequest request
            );
}
