package com.appledeveloperacademy.soongies.domain.test.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.client.GoogleClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final GoogleClient googleClient;

    @Override
    public GoogleOauthResponse.GoogleDeviceCodeResponse testFeign(GoogleOauthRequest.GoogleDeviceCodeRequest request) {
        System.out.println(request);
        return googleClient.getUserCode(request);
    }
}
