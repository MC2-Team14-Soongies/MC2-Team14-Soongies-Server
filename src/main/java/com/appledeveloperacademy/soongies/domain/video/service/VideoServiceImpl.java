package com.appledeveloperacademy.soongies.domain.video.service;

import com.appledeveloperacademy.soongies.config.YoutubeConfig;
import com.appledeveloperacademy.soongies.domain.youtube.client.YoutubeClient;
import com.appledeveloperacademy.soongies.domain.youtube.dto.YoutubeDataApiV3Response;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoRequest;
import com.appledeveloperacademy.soongies.domain.video.dto.VideoResponse;
import com.appledeveloperacademy.soongies.domain.video.mapper.VideoMapper;
import com.appledeveloperacademy.soongies.domain.ytmusic.client.YTMusicApiClient;
import com.appledeveloperacademy.soongies.domain.ytmusic.dto.YTMusicApiResponse;
import com.appledeveloperacademy.soongies.domain.ytmusic.mapper.YTMusicApiMapper;
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
    private final YTMusicApiClient ytMusicApiClient;
    private final YTMusicApiMapper ytMusicApiMapper;

    @Override
    public VideoResponse.VideoSearchListResponse searchVideo(String part, int maxResults, String q, String type, int videoCategory, String key, String order) {

        List<VideoResponse.VideoInfo> videoInfoList = new ArrayList<>();

        YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse youtubeDataApiV3SearchListResponse = youtubeClient.searchVideo(part, maxResults, q, type, videoCategory, key, order);

        youtubeDataApiV3SearchListResponse.getItems().forEach(searchListItem -> {

            System.out.println("--------------------------------");
            // TODO: 각 비디오 ID 값에 대한 상세 정보 조회 및 리스트 (조회순) 정렬
            String videoId = searchListItem.getId().getVideoId();
            YTMusicApiResponse.YTMusicApiGetSongResponse videoDetail = ytMusicApiClient.getSong(videoId);

//            YoutubeDataApiV3Response.YoutubeDataApiV3VideoGetDetailResponse videoDetail = youtubeClient.getVideoDetail(videoId, "snippet,statistics,contentDetails", key);
//            YoutubeDataApiV3Response.GetVideoDetailItem videoDetailItem = videoDetail.getItems().get(0);
//                // TODO: Thumbnail이 null일 때 처리, 조회수 안불러와지는 오류 수정
            try {
                String json = objectMapper.writeValueAsString(videoDetail);
                logger.info("Object as JSON: {}", json);
            } catch (JsonProcessingException e) {
                logger.error("Error while converting object to JSON", e);
            }
            videoInfoList.add(videoMapper.toVideoInfo(videoDetail));
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

    @Override
    public VideoResponse.VideoCreatePlaylistResponse createPlayList(VideoRequest.VideoCreatePlaylistRequest request) {

        // 임시 리스트 생성
        List<VideoResponse.VideoInfo> videoInfoList = new ArrayList<>();

        // --------------임시 search Setting-------------
        String part = "id";
        int maxResults = 20;
        String type = "video";
        int videoCategory = 10;
        String key = youtubeConfig.getApiKey();
        String order = "viewCount";
        // ---------------------------------------------

        Long restTime = request.getRestTime() - request.getFinaleInfo().getLength();
        Long playlistLength = 0L;

        YoutubeDataApiV3Response.YoutubeDataApiV3SearchListResponse youtubeDataApiV3SearchListResponse = youtubeClient.searchVideo(part, maxResults, request.getFinaleInfo().getArtist(), type, videoCategory, key, order);

        for (YoutubeDataApiV3Response.SearchListItem searchListItem : youtubeDataApiV3SearchListResponse.getItems()) {

            // 수정해야됨
            YTMusicApiResponse.YTMusicApiGetSongResponse videoDetail = ytMusicApiClient.getSong(searchListItem.getId().getVideoId());
            System.out.println(videoDetail);
            System.out.println(videoDetail.getVideoDetails().getVideoId());
            System.out.println(videoDetail.getVideoDetails().getAuthor());
            System.out.println(videoDetail.getVideoDetails().getLengthSeconds());
            System.out.println(videoDetail.getVideoDetails().getThumbnail().getThumbnails());
            System.out.println(videoDetail.getVideoDetails().getTitle());
            System.out.println(videoDetail.getVideoDetails().getViewCount());

            try {
                String json = objectMapper.writeValueAsString(videoDetail);
                logger.info("Object as JSON: {}", json);
            } catch (JsonProcessingException e) {
                logger.error("Error while converting object to JSON", e);
            }

            Long videoLength = Long.parseLong(videoDetail.getVideoDetails().getLengthSeconds());
            if(restTime - videoLength >= 0 && videoLength >= 120) {
                restTime -= videoLength;
                System.out.println("restTime : " + restTime);
                System.out.println("videoLength : " + videoLength);
                System.out.println("restTime - videoLength : " + (restTime - videoLength));
                videoInfoList.add(videoMapper.toVideoInfo(videoDetail));
                playlistLength += videoLength;
            }
        };

        videoInfoList.add(videoMapper.toVideoInfo(request.getFinaleInfo()));
        playlistLength += request.getFinaleInfo().getLength();


        videoInfoList.forEach(item -> {
            System.out.println(item.getVideoId());
            System.out.println(item.getTitle());
            System.out.println(item.getArtist());
            System.out.println(item.getDuration());
            System.out.println(item.getThumbnail());
            System.out.println(item.getViewCount());
        });

        // ----------------------------------------


        return videoMapper.toVideoCreatePlayListResponse(playlistLength, videoInfoList);
    }

    @Override
    public VideoResponse.VideoExportPlaylistResponse exportPlaylist(VideoRequest.VideoExportPlaylistRequest request) {
        YTMusicApiResponse.YTMusicAPIExportPlaylistResponse response = ytMusicApiClient.exportPlaylist(ytMusicApiMapper.toYTMusicAPiExportPlaylistRequest(request));
        return videoMapper.toVideoExportPlaylistResponse(response);
    }


}
