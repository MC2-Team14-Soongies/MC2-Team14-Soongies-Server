package com.appledeveloperacademy.soongies.domain.youtube.client;

import com.appledeveloperacademy.soongies.config.FeignConfig;
import com.appledeveloperacademy.soongies.domain.youtube.dto.YoutubeDataApiV3Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "YoutubeDataApiV3Client",
        url = "https://www.googleapis.com/youtube/v3",
        configuration = FeignConfig.class
)
public interface YoutubeClient {

    @GetMapping(value = "/search")
    public YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse searchVideo(
            @RequestParam("part") String part,
            @RequestParam("maxResults") int maxResults,
            @RequestParam("q") String q,
            @RequestParam("type") String type,
            @RequestParam("videoCategory") int videoCategory,
            @RequestParam("key") String key,
            @RequestParam("order") String order
    );

    @GetMapping(value = "/videos")
    public YoutubeDataApiV3Response.YoutubeDataApiV3VideoGetDetailResponse getVideoDetail(
            @RequestParam("id") String id,
            @RequestParam("part") String part,
            @RequestParam("key") String key
    );
}
