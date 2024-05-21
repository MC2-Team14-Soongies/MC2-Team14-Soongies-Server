package com.appledeveloperacademy.soongies.domain.member.mapper;

import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberResponse.MemberGoogleOauthUrlResponse toMemberGoogleOauthUrl(String googleOauthUrl, String deviceCode) {
        return MemberResponse.MemberGoogleOauthUrlResponse.builder()
                .googleOauthUrl(googleOauthUrl)
                .code(deviceCode)
                .build();
    }

}
