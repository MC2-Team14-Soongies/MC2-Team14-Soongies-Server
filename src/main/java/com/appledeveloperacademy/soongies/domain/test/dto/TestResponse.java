package com.appledeveloperacademy.soongies.domain.test.dto;

import lombok.Builder;
import lombok.Getter;

public class TestResponse {

    @Getter
    @Builder
    public static class BaseResponseTest {
        private String testString;
    }
}
