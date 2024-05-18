package com.appledeveloperacademy.soongies.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberResponse {

    @Getter
    @Builder
    public static class getGoogleOauthUrl {
        private String device_code;
    }
}
