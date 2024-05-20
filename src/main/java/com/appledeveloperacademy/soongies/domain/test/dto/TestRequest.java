package com.appledeveloperacademy.soongies.domain.test.dto;

import lombok.Builder;
import lombok.Data;

public class TestRequest {

    @Data
    public static class TestNicknameRequest {
        private String nickname;
    }
}
