package com.appledeveloperacademy.soongies.domain.test.controller;

import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthRequest;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.GoogleOauthResponse;
import com.appledeveloperacademy.soongies.domain.test.dto.TestRequest;
import com.appledeveloperacademy.soongies.domain.test.dto.TestResponse;
import com.appledeveloperacademy.soongies.domain.test.service.TestService;
import com.appledeveloperacademy.soongies.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Tag(name = "swagger setting test", description = "스웨거 테스트")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

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

    @Operation(summary = "POST 닉네임 출력 테스트 API", description = "김카야 스프링 정복기")
    @PostMapping("/post-nickname")
    public BaseResponse<TestResponse.TestAnnaResponse> postNickname(
            @RequestBody TestRequest.TestNicknameRequest request
            ) {
        return BaseResponse.onSuccess(testService.getNickname(request));
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
    public BaseResponse<TestResponse.TestBaseResponse> getBaseResponseTest() {
        TestResponse.TestBaseResponse baseResponseTest = TestResponse.TestBaseResponse.builder()
                .testString("TEST")
                .build();
        return BaseResponse.onSuccess(baseResponseTest);
    }

    @Operation(summary = "OepnFeign 테스트 API", description = "OpenFeign 테스트 API입니다.")
    @PostMapping("/open-feign-test")
    public BaseResponse<GoogleOauthResponse.GoogleDeviceCodeResponse> getGoogleOauth(
            @RequestBody GoogleOauthRequest.GoogleDeviceCodeRequest request) {

        return BaseResponse.onSuccess(testService.testFeign(request));
    }

}
