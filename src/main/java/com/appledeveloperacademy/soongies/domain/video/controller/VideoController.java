package com.appledeveloperacademy.soongies.domain.video.controller;

import com.appledeveloperacademy.soongies.config.YoutubeConfig;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoRequest;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import com.appledeveloperacademy.soongies.domain.video.service.VideoService;
import com.appledeveloperacademy.soongies.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
@Tag(name = "비디오 API", description = "비디오 API 입니다.")
public class VideoController {

    private final VideoService videoService;
    private final YoutubeConfig youtubeConfig;

    @Operation(summary = "비디오 검색 API", description = "비디오를 검색합니다.")
    @GetMapping("/search")
    private BaseResponse<VideoResponse.VideoSearchListResponse> searchVideos(
//            @RequestParam("part") String part,
//            @RequestParam("maxResults") int maxResults,
//            @RequestParam("type") String type,
//            @RequestParam("videoCategory") int videoCategory,
//            @RequestParam("key") String key,
            @RequestParam("q") String q
    ) {
        String part = "id";
        int maxResults = 20;
        String type = "video";
        int videoCategory = 10;
        String key = youtubeConfig.getApiKey();
        String order = "viewCount";

        return BaseResponse.onSuccess(videoService.searchVideo(part, maxResults, q, type, videoCategory, key, order));
    }

    @Operation(summary = "플레이리스트 생성 API", description = "플레이리스트를 생성합니다.")
    @PostMapping("/playlist")
    private BaseResponse<VideoResponse.VideoCreatePlaylistResponse> createPlayList(
            @RequestBody VideoRequest.VideoCreatePlaylistRequest request
    ) {

        return BaseResponse.onSuccess(videoService.createPlayList(request));
    }

    @Operation(summary = "플레이리스트 내보내기 API", description = "플레이리스트 내보내기 API 입니다.")
    @PostMapping("/playlist/export")
    private BaseResponse<VideoResponse.VideoExportPlaylistResponse> exportPlaylist(
            @RequestBody VideoRequest.VideoExportPlaylistRequest request
    ) {

        return BaseResponse.onSuccess((videoService.exportPlaylist(request)));
    }

}
