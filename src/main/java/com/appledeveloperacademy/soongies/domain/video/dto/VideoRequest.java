package com.appledeveloperacademy.soongies.domain.video.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class VideoRequest {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class VideoCreatePlaylistRequest {
        private Long restTime;
        private CreatePlaylistFinaleInfo finaleInfo;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreatePlaylistFinaleInfo {
        private String title;
        private String artist;
        private String videoId;
        private Long length;
        private String thumbnail;
        private Long viewCount;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class VideoExportPlaylistRequest {
        private List<String> videoList;
    }
}
