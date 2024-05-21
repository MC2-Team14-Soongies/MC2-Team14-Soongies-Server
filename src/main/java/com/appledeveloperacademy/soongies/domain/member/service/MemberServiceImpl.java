package com.appledeveloperacademy.soongies.domain.member.service;

import com.appledeveloperacademy.soongies.config.GoogleConfig;
import com.appledeveloperacademy.soongies.config.security.oauth.google.client.GoogleClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import com.appledeveloperacademy.soongies.domain.member.dto.MemberRequest;
import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import com.appledeveloperacademy.soongies.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final GoogleClient googleClient;
    private final MemberMapper memberMapper;
    private final GoogleConfig googleConfig;

    @Override
    public MemberResponse.MemberGoogleOauthUrlResponse getGoogleOauthUrl(GoogleOauthRequest.GoogleOauthDeviceCodeRequest request) {
        GoogleOauthResponse.GoogleOauthDeviceCodeResponse deviceInfo = googleClient.getDeviceInfo(request);
        String googleOauthUrl = "https://accounts.google.com/o/oauth2/device/usercode?user_code=" + deviceInfo.getUserCode() + "&ddm=0&flowName=DeviceOAuth";
        System.out.println(deviceInfo.getDeviceCode());
        System.out.println(deviceInfo.getUserCode());

        System.out.println(googleConfig.getGrantType());
        System.out.println(googleConfig.getClientId());
        System.out.println(googleConfig.getClientSecret());
        System.out.println(googleConfig.getApiKey());

        return memberMapper.toMemberGoogleOauthUrl(googleOauthUrl, deviceInfo.getDeviceCode());
    }

    @Override
    public MemberResponse.MemberGoogleOauthTokenResponse getGoogleOauthToken(MemberRequest.MemberGetGoogleOauthInfoRequest request) {
        GoogleOauthRequest.GoogleOauthTokenRequest googleOauthTokenRequest = GoogleOauthRequest.GoogleOauthTokenRequest.builder()
                .clientId(googleConfig.getClientId())
                .clientSecret(googleConfig.getClientSecret())
                .code(request.getCode())
                .grantType(googleConfig.getGrantType())
                .build();
        System.out.println(googleOauthTokenRequest.getClientId());
        System.out.println(googleOauthTokenRequest.getClientSecret());
        System.out.println(googleOauthTokenRequest.getCode());
        System.out.println(googleOauthTokenRequest.getGrantType());


        GoogleOauthResponse.GoogleOauthTokenResponse googleOauthToken = googleClient.getTokenInfo(googleOauthTokenRequest);
        System.out.println(googleOauthToken.getAccessToken());
        System.out.println(googleOauthToken.getRefreshToken());

        return null;
    }
}
