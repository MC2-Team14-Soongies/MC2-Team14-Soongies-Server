package com.appledeveloperacademy.soongies.domain.test.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.client.GoogleClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import com.appledeveloperacademy.soongies.domain.test.dto.TestRequest;
import com.appledeveloperacademy.soongies.domain.test.dto.TestResponse;
import com.appledeveloperacademy.soongies.domain.test.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final GoogleClient googleClient;
    private final TestMapper testMapper;

    @Override
    public GoogleOauthResponse.GoogleOauthDeviceCodeResponse testFeign(GoogleOauthRequest.GoogleOauthDeviceCodeRequest request) {
        System.out.println(request);
        return googleClient.getDeviceInfo(request);
    }

    @Override
    public TestResponse.TestAnnaResponse getNickname(TestRequest.TestNicknameRequest request) {
        String fullName = "안혜림/" + request.getNickname();
        return testMapper.toTestAnnaResponse(fullName);
    }
}
