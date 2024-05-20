package com.appledeveloperacademy.soongies.domain.test.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;

public interface TestService {

    GoogleOauthResponse.GoogleDeviceCodeResponse testFeign(GoogleOauthRequest.GoogleDeviceCodeRequest request);
}
