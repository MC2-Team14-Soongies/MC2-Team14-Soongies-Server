package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.core.annotation.MergedAnnotations;

import java.util.List;

public class YoutubeDataApiV3Response {

    // SearchListResponse
    @Getter
    @Builder
    @ToString
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class YoutubeDataApiV3SearchListResponse {
        private String kind;
        private String etag;
        private String nextPageToken;
        private String prevPageToken;
        private String regionCode;
        private SearchListPageInfo pageInfo;
        private List<SearchListItem> items;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class SearchListPageInfo {
        private int totalResults;
        private int resultsPerPage;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class SearchListItem {
        private String kind;
        private String etag;
        private IdInfo id;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class IdInfo {
        private String kind;
        private String videoId;
    }

    // GetDetailResponse
    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class YoutubeDataApiV3VideoGetDetailResponse {
        private String kind;
        private String etag;
        private List<GetVideoDetailItem> items;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GetVideoDetailItem {
        private String kind;
        private String etag;
        private String id;
        private GetVideoDetailItemSnippet snippet;
        private GetVideoDetailItemStatics statistics;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GetVideoDetailItemSnippet {
        private String title;
        private GetVideoDetailItemSnippetThumbnails thumbnails;
    }

    @Getter
    @Builder
    @Jacksonized
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GetVideoDetailItemSnippetThumbnails {
        private GetVideoDetailItemSnippetThumbnailsMaxres maxres;
    }

    @Getter
    @Builder
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GetVideoDetailItemSnippetThumbnailsMaxres {
        private String url;
        private int width;
        private int height;

    }

    @Getter
    @Builder
    @Jacksonized
    @JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class GetVideoDetailItemStatics {
        private String viewCount;
    }


}
