package com.appledeveloperacademy.soongies.domain.ytmusic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class YTMusicApiResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class YTMusicApiGetSongResponse {
        @JsonProperty("videoDetails")
        private GetSongVideoDetails videoDetails;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class GetSongVideoDetails {
        @JsonProperty("videoId")
        private String videoId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("lengthSeconds")
        private String lengthSeconds;
        @JsonProperty("thumbnail")
        private GetSongVideoDetailsThumbnail thumbnail;
        @JsonProperty("viewCount")
        private String viewCount;
        @JsonProperty("author")
        private String author;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class GetSongVideoDetailsThumbnail {
        @JsonProperty("thumbnails")
        private List<GetSongVideoDetailsThumbnailInfo> thumbnails;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class GetSongVideoDetailsThumbnailInfo {
        @JsonProperty("url")
        private String url;
        @JsonProperty("width")
        private Long width;
        @JsonProperty("height")
        private Long height;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class YTMusicApiExportPlaylistResponse {
        @JsonProperty("playlistId")
        private String playlistId;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class YTMusicApiUpdateTokensResponse {
        @JsonProperty("refreshToken")
        private String refreshToken;
    }

}
