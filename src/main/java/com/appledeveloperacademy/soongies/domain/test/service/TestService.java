package com.appledeveloperacademy.soongies.domain.test.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import com.appledeveloperacademy.soongies.domain.test.dto.TestRequest;
import com.appledeveloperacademy.soongies.domain.test.dto.TestResponse;

public interface TestService {

    GoogleOauthResponse.GoogleOauthDeviceCodeResponse testFeign(GoogleOauthRequest.GoogleOauthDeviceCodeRequest request);


    TestResponse.TestAnnaResponse getNickname(TestRequest.TestNicknameRequest request);
}
