package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.ChannelSearch;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;
    private final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";
    public VideoSnippet findVideos(String videoId){
        String uri= "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&id=" +videoId +"&key=" + token;

        HttpHeaders headers= new HttpHeaders();
        headers.set("X-goog-api-key", token);

        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoSnippetSearch.class);

        assert response.getBody() != null;
        return response.getBody().getItems().get(0);
    }

}
