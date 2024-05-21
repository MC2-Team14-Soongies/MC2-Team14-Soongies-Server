package com.appledeveloperacademy.soongies.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberRequest {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class MemberGetGoogleOauthInfoRequest {
        private String code;
    }
}
