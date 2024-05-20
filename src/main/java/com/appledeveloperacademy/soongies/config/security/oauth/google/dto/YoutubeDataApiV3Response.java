package com.appledeveloperacademy.soongies.config.security.oauth.google.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.core.annotation.MergedAnnotations;

import java.util.List;

public class YoutubeDataApiV3Response {
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



}
