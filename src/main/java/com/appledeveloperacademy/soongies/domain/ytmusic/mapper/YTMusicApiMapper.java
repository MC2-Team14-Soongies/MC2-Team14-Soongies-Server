package com.appledeveloperacademy.soongies.domain.ytmusic.mapper;

import com.appledeveloperacademy.soongies.domain.video.dto.VideoRequest;
import com.appledeveloperacademy.soongies.domain.ytmusic.dto.YTMusicApiRequest;
import org.springframework.stereotype.Component;

@Component
public class YTMusicApiMapper {

    public YTMusicApiRequest.YTMusicAPiExportPlaylistRequest toYTMusicAPiExportPlaylistRequest(VideoRequest.VideoExportPlaylistRequest request) {
        return YTMusicApiRequest.YTMusicAPiExportPlaylistRequest.builder()
                .videoList(request.getVideoList())
                .build();
    }

}
