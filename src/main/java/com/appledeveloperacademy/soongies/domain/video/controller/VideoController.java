package com.appledeveloperacademy.soongies.domain.video.controller;

import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import com.appledeveloperacademy.soongies.domain.video.service.VideoService;
import com.appledeveloperacademy.soongies.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
@Tag(name = "비디오 API", description = "비디오 API 입니다.")
public class VideoController {

    private final VideoService videoService;

    @Operation(summary = "비디오 검색 API", description = "비디오를 검색합니다.")
    @GetMapping("/search")
    private BaseResponse<VideoResponse.VideoSearchListResponse> searchVideos(
            @RequestParam("part") String part,
            @RequestParam("maxResults") int maxResults,
            @RequestParam("q") String q,
            @RequestParam("type") String type,
            @RequestParam("videoCategory") int videoCategory,
            @RequestParam("key") String key
    ) {

        return BaseResponse.onSuccess(videoService.searchVideo(part, maxResults, q, type, videoCategory, key));
    }

}
