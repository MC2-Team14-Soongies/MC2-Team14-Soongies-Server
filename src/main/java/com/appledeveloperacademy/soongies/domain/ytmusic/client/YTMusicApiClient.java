package com.appledeveloperacademy.soongies.domain.ytmusic.client;

import com.appledeveloperacademy.soongies.config.FeignConfig;
import com.appledeveloperacademy.soongies.domain.youtube.dto.YoutubeDataApiV3Response;
import com.appledeveloperacademy.soongies.domain.ytmusic.dto.YTMusicApiRequest;
import com.appledeveloperacademy.soongies.domain.ytmusic.dto.YTMusicApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "YTMusicApiClient",
        url = "http://localhost:8000",
        configuration = FeignConfig.class
)
public interface YTMusicApiClient {
    @GetMapping(value = "/get-song")
    public YTMusicApiResponse.YTMusicApiGetSongResponse getSong(
            @RequestParam("videoId") String videoId
    );

    @PostMapping(value = "/playlist")
    public YTMusicApiResponse.YTMusicAPIExportPlaylistResponse exportPlaylist(
            @RequestBody YTMusicApiRequest.YTMusicAPiExportPlaylistRequest request
    );
}
