package com.appledeveloperacademy.soongies.domain.member.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.client.GoogleClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import com.appledeveloperacademy.soongies.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final GoogleClient googleClient;
    private final MemberMapper memberMapper;
    @Override
    public MemberResponse.MemberGoogleOauthUrl getGoogleOauthUrl(GoogleOauthRequest.GoogleDeviceCodeRequest request) {
        String googleOauthUrl = "https://accounts.google.com/o/oauth2/device/usercode?user_code=" + googleClient.getUserCode(request).getUser_code() + "&ddm=0&flowName=DeviceOAuth";
        return memberMapper.toMemberGoogleOauthUrl(googleOauthUrl);
    }
}
