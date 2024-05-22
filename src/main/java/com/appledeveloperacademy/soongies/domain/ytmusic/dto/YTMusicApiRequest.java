package com.appledeveloperacademy.soongies.domain.ytmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class YTMusicApiRequest {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class YTMusicApiGetSongRequest {
        private String videoId;
    }
}
