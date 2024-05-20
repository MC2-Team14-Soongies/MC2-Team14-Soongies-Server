package com.appledeveloperacademy.soongies.domain.video.service;

import com.appledeveloperacademy.soongies.config.security.oauth.google.client.YoutubeClient;
import com.appledeveloperacademy.soongies.config.security.oauth.google.dto.YoutubeDataApiV3Response;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final YoutubeClient youtubeClient;
    @Override
    public VideoResponse.VideoSearchListResponse searchVideo(String part, int maxResults, String q, String type, int videoCategory, String key) {
        YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse youtubeDataApiV3SearchListResponse = youtubeClient.searchVideo(part, maxResults, q, type, videoCategory, key);

        youtubeDataApiV3SearchListResponse.getItems().forEach(item -> {
            // TODO: 각 비디오 ID 값에 대한 상세 정보 조회 및 리스트 (조회순) 정렬
            System.out.println(item.getId().getVideoId());
        });
        return null;
    }
}
