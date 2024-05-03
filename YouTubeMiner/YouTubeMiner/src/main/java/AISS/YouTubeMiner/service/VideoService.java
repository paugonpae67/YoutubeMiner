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
    public VideoSnippet findVideo(String videoId){
        String uri= "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&id=" +videoId +"&key=" + token;

        HttpHeaders headers= new HttpHeaders();
        headers.set("X-goog-api-key", token);

        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<VideoSnippetSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoSnippetSearch.class);

        assert response.getBody() != null;
        return response.getBody().getItems().get(0);
    }

    public List<VideoSnippet> findVideos(String userName, Integer maxVideo){
        HttpHeaders headers= new HttpHeaders();
        headers.set("X-goog-api-key", token);
        String playlistId=getPlaylistId(userName);
        HttpEntity<VideoSnippetSearch> request = new HttpEntity<>(null,headers);
        String uri = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+playlistId+"&maxResults="+ maxVideo+"&key="+token;
        ResponseEntity<VideoSnippetSearch>response2 = restTemplate.exchange(uri, HttpMethod.GET, request, VideoSnippetSearch.class);

        assert response2.getBody() != null;
        return response2.getBody().getItems();

    }

    public String getPlaylistId(String userName){
        String uri= "https://youtube.googleapis.com/youtube/v3/channels?part=contentDetails&forUsername=" +userName +"&key=" + token;
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);
        assert response.getBody() !=null;
        String playlistId= response.getBody().getItems().get(0).getContentDetails().getRelatedPlaylists().getUploads();
        return playlistId;
    }

}
