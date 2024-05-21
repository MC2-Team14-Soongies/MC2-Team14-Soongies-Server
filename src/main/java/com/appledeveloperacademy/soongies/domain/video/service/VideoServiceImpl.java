package com.appledeveloperacademy.soongies.domain.video.service;

import com.appledeveloperacademy.soongies.config.YoutubeConfig;
import com.appledeveloperacademy.soongies.config.security.oauth.google.client.YoutubeClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.YoutubeDataApiV3Response;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import com.appledeveloperacademy.soongies.domain.video.mapper.VideoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final YoutubeClient youtubeClient;
    private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);
    private final ObjectMapper objectMapper;
    private final YoutubeConfig youtubeConfig;
    private final VideoMapper videoMapper;

    @Override
    public VideoResponse.VideoSearchListResponse searchVideo(String part, int maxResults, String q, String type, int videoCategory, String key) {

        List<VideoResponse.VideoInfo> videoInfoList = new ArrayList<>();

        YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse youtubeDataApiV3SearchListResponse = youtubeClient.searchVideo(part, maxResults, q, type, videoCategory, key);

        youtubeDataApiV3SearchListResponse.getItems().forEach(searchListItem -> {

            System.out.println("--------------------------------");
            // TODO: 각 비디오 ID 값에 대한 상세 정보 조회 및 리스트 (조회순) 정렬
            String videoId = searchListItem.getId().getVideoId();
            YoutubeDataApiV3Response.YoutubeDataApiV3VideoGetDetailResponse videoDetail = youtubeClient.getVideoDetail(videoId, "snippet,statistics,contentDetails", key);
            YoutubeDataApiV3Response.GetVideoDetailItem videoDetailItem = videoDetail.getItems().getFirst();
//                // TODO: Thumbnail이 null일 때 처리, 조회수 안불러와지는 오류 수정
            try {
                String json = objectMapper.writeValueAsString(videoDetail);
                logger.info("Object as JSON: {}", json);
            } catch (JsonProcessingException e) {
                logger.error("Error while converting object to JSON", e);
            }
            videoInfoList.add(videoMapper.toVideoInfo(videoDetailItem));
            System.out.println("--------------------------------");
        });

        videoInfoList.forEach(item -> {
            System.out.println(item.getTitle());
            System.out.println(item.getArtist());
            System.out.println(item.getDuration());
            System.out.println(item.getThumbnail());
            System.out.println(item.getViewCount());
        });

        return videoMapper.toVideoSearchListResponse(videoInfoList);
    }
}
