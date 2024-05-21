package com.appledeveloperacademy.soongies.domain.video.service;

import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;

public interface VideoService {
    VideoResponse.VideoSearchListResponse searchVideo(String part, int maxResults, String q, String type, int videoCategory, String key);
}
