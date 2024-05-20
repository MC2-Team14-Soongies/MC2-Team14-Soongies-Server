package com.appledeveloperacademy.soongies.domain.test.dto;

import lombok.Builder;
import lombok.Getter;

public class TestResponse {

    @Getter
    @Builder
    public static class TestBaseResponse {
        private String testString;
    }

    @Getter
    @Builder
    public static class TestAnnaResponse {
        private String nickname;
    }
}
