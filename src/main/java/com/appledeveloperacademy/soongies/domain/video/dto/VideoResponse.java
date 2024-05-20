package com.appledeveloperacademy.soongies.domain.video.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class VideoResponse {

    @Getter
    @Builder
    public static class VideoSearchListResponse {
        private List<VideoInfo> videoInfoList;
    }

    @Getter
    @Builder
    public static class VideoInfo {
        private String thumbnail;
        private String name;
        private String singer;
        private String duration;
    }

}
