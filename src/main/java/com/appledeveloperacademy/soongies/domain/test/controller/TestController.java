package com.appledeveloperacademy.soongies.domain.test.controller;

import com.appledeveloperacademy.soongies.domain.test.dto.TestResponse;
import com.appledeveloperacademy.soongies.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "swagger setting test", description = "스웨거 테스트")
@RestController
@RequiredArgsConstructor
public class TestController {

    @Value("${app.version:1.0.0}")
    String version;

    @GetMapping("/version")
    public String version() {
        return "Hello CI/CD! version: " + version;
    }


    @GetMapping("/")
    public String home() {
        return "Hello CI/CD! version: " + version;
    }

    @Operation(summary = "리버 테스트 API", description = "CI/CD 및 스웨거 확인용 API입니다.")
    @GetMapping("/liver")
    public String getLiverNickname() {
        return "My name is Liver";
    }

    @Operation(summary = "카야 출력 테스트 API", description = "CI/CD 및 스웨거 확인용 API입니다.")
    @GetMapping("/kaya")
    public String getKayaNickname() {
        return "My name is Kaya";
    }

    @Operation(summary = "닉네임 입력/출력 테스트 API", description = "CI/CD 및 스웨거 확인용 API입니다.")
    @GetMapping("/getNickname")
    public String getNickname(
            @RequestParam(name = "nickname") String nickname
    ) {
        return "My name is " + nickname;
    }

    @Operation(summary = "BaseResponse 테스트 API", description = "BaseResponse 테스트 API입니다.")
    @GetMapping("/base-response-test")
    public BaseResponse<TestResponse.BaseResponseTest> getBaseResponseTest() {
        TestResponse.BaseResponseTest baseResponseTest = TestResponse.BaseResponseTest.builder()
                .testString("TEST")
                .build();
        return BaseResponse.onSuccess(baseResponseTest);
    }

}