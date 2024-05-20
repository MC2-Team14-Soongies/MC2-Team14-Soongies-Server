package com.appledeveloperacademy.soongies.domain.member.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;

public interface MemberService {
    MemberResponse.MemberGoogleOauthUrlResponse getGoogleOauthUrl(GoogleOauthRequest.GoogleOauthDeviceCodeRequest request);

    MemberResponse.MemberGoogleOauthTokenResponse getGoogleOauthToken(GoogleOauthRequest.GoogleOauthTokenRequest request);
}
