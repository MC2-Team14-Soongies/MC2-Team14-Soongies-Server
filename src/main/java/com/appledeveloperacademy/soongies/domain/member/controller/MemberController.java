package com.appledeveloperacademy.soongies.domain.member.controller;

import com.appledeveloperacademy.soongies.domain.member.dto.MemberResponse;
import com.appledeveloperacademy.soongies.domain.member.service.MemberService;
import com.appledeveloperacademy.soongies.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memebers")
@Tag(name = "멤버 API", description = "멤버 API입니다.")
public class MemberController {

    private final MemberService memberservice;

    @Operation(summary = "구글 로그인 url 조회 API", description = "구글 Oauth url 조회 API입니다.")
    @GetMapping("/google-oauth-url")
    public BaseResponse<MemberResponse.getGoogleOauthUrl> getGoogleOauthUrl() {

        return null;
    }


}
