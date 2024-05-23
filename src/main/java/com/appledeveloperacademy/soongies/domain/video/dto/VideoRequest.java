package com.appledeveloperacademy.soongies.domain.video.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class VideoRequest {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class VideoCreatePlayListRequest {
        private Long restTime;
        private CreatePlayListFinaleInfo finaleInfo;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreatePlayListFinaleInfo {
        private String title;
        private String artist;
        private String videoId;
    }
}
