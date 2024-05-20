package com.appledeveloperacademy.soongies.domain.member.mapper;

import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberResponse.MemberGoogleOauthUrl toMemberGoogleOauthUrl(String googleOauthUrl) {
        return MemberResponse.MemberGoogleOauthUrl.builder()
                .googleOauthUrl(googleOauthUrl)
                .build();
    }

}
