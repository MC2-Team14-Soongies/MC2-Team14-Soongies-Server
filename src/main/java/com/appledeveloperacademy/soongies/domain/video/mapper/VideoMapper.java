package com.appledeveloperacademy.soongies.domain.video.mapper;

import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.YoutubeDataApiV3Response;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VideoMapper {

//    public VideoResponse.VideoSearchListResponse toVideoSearchList(List<YoutubeDataApiV3Response.YoutubeDataApiV3VideoGetDetailResponse>) {
//        return VideoResponse.VideoSearchListResponse.builder().build();
//    }

    public VideoResponse.VideoSearchListResponse toVideoSearchListResponse(List<VideoResponse.VideoInfo> videoInfoList) {
        return VideoResponse.VideoSearchListResponse.builder()
                .videoInfoList(videoInfoList)
                .build();
    }

    public VideoResponse.VideoInfo toVideoInfo(YoutubeDataApiV3Response.GetVideoDetailItem item) {
        String thumbnail = Optional.ofNullable(item.getSnippet())
                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippet::getThumbnails)
                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippetThumbnails::getMaxres)
                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippetThumbnailsMaxres::getUrl)
                .orElse("default_thumbnail.jpg");
        return VideoResponse.VideoInfo.builder()
                .videoId(item.getId())
                .title(item.getSnippet().getTitle())
                .artist(item.getSnippet().getChannelTitle())
                .duration(item.getContentDetails().getDuration())
                .thumbnail(thumbnail)
                .viewCount(Long.valueOf(item.getStatistics().getViewCount()))
                .build();
    }
}
