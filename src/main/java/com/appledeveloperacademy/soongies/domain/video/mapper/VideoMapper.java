package com.appledeveloperacademy.soongies.domain.video.mapper;

import com.appledeveloperacademy.soongies.domain.video.dto.VideoRequest;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import com.appledeveloperacademy.soongies.domain.ytmusic.dto.YTMusicApiResponse;
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

    public VideoResponse.VideoCreatePlaylistResponse toVideoCreatePlayListResponse(Long playlistLength, List<VideoResponse.VideoInfo> videoInfoList) {
        return VideoResponse.VideoCreatePlaylistResponse.builder()
                .videoInfoList(videoInfoList)
                .playlistLength(playlistLength)
                .build();
    }

    public VideoResponse.VideoExportPlaylistResponse toVideoExportPlaylistResponse(YTMusicApiResponse.YTMusicApiExportPlaylistResponse response) {
        return VideoResponse.VideoExportPlaylistResponse.builder()
                .playlistId(response.getPlaylistId())
                .build();
    }

    // Youtube Data Api v3용
//    public VideoResponse.VideoInfo toVideoInfo(YoutubeDataApiV3Response.GetVideoDetailItem item) {
//        String thumbnail = Optional.ofNullable(item.getSnippet())
//                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippet::getThumbnails)
//                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippetThumbnails::getMaxres)
//                .map(YoutubeDataApiV3Response.GetVideoDetailItemSnippetThumbnailsMaxres::getUrl)
//                .orElse("default_thumbnail.jpg");
//        return VideoResponse.VideoInfo.builder()
//                .videoId(item.getId())
//                .title(item.getSnippet().getTitle())
//                .artist(item.getSnippet().getChannelTitle())
//                .duration(item.getContentDetails().getDuration())
//                .thumbnail(thumbnail)
//                .viewCount(Long.valueOf(item.getStatistics().getViewCount()))
//                .build();
//    }

    // YTMusicApi 용
        public VideoResponse.VideoInfo toVideoInfo(YTMusicApiResponse.YTMusicApiGetSongResponse item) {
            String thumbnailUrl = Optional.ofNullable(item.getVideoDetails())
                    .map(YTMusicApiResponse.GetSongVideoDetails::getThumbnail)
                    .map(YTMusicApiResponse.GetSongVideoDetailsThumbnail::getThumbnails)
                    .filter(thumbnails -> !thumbnails.isEmpty()) // 썸네일 목록이 비어있지 않은지 확인
                    .map(thumbnails -> thumbnails.get(0)) // 첫 번째 썸네일을 가져옵니다.
                    .map(YTMusicApiResponse.GetSongVideoDetailsThumbnailInfo::getUrl)
                    .orElse("default_thumbnail.jpg"); // 모든 검사를 통과하지 못하면 기본 썸네일 URL을 사용

        return VideoResponse.VideoInfo.builder()
                .videoId(item.getVideoDetails().getVideoId())
                .title(item.getVideoDetails().getTitle())
                .artist(item.getVideoDetails().getAuthor())
                .duration(item.getVideoDetails().getLengthSeconds())
                .thumbnail(thumbnailUrl)
                .viewCount(Long.valueOf(item.getVideoDetails().getViewCount()))
                .build();
    }

    public VideoResponse.VideoInfo toVideoInfo(VideoRequest.CreatePlaylistFinaleInfo finaleInfo) {

        return VideoResponse.VideoInfo.builder()
                .videoId(finaleInfo.getVideoId())
                .title(finaleInfo.getTitle())
                .artist(finaleInfo.getArtist())
                .duration(finaleInfo.getLength().toString())
                .thumbnail(finaleInfo.getThumbnail())
                .viewCount(finaleInfo.getViewCount())
                .build();
    }
}
