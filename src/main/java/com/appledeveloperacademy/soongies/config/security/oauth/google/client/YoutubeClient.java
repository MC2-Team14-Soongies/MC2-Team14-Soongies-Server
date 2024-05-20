package com.appledeveloperacademy.soongies.config.security.oauth.google.client;

import com.appledeveloperacademy.soongies.config.FeignConfig;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.YoutubeDataApiV3Request;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.YoutubeDataApiV3Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "YoutubeDataApiV3Client",
        url = "https://www.googleapis.com/youtube/v3",
        configuration = FeignConfig.class
)
public interface YoutubeClient {

    @GetMapping(value = "/search")
    public YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse searchVideo(
            @RequestParam("part") String part,
            @RequestParam("maxResults") int maxResults,
            @RequestParam("q") String q,
            @RequestParam("type") String type,
            @RequestParam("videoCategory") int videoCategory,
            @RequestParam("key") String key
    );

    @PostMapping(value = "/token")
    public GoogleOauthResponse.GoogleOauthTokenResponse getTokenInfo(
            @RequestBody GoogleOauthRequest.GoogleOauthTokenRequest request
    );
}
