package com.appledeveloperacademy.soongies.domain.video.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class VideoResponse {

    @Getter
    @Builder
    public static class VideoCreatePlayListResponse {
        private List<VideoInfo> videoInfoList;
        private Long playlistLength;
    }

    @Getter
    @Builder
    public static class VideoSearchListResponse {
        private List<VideoInfo> videoInfoList;
    }

    @Getter
    @Builder
    public static class VideoInfo {
        private String videoId;
        private String thumbnail;
        private String title;
        private String artist;
        private String duration;
        private Long viewCount;
    }

}
