package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.ChannelYouTube;
import AISS.YouTubeMiner.model.youtube.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    private final static String token = "AIzaSyBuOr1tTp7kcvBLNjQ3M4aBJ0R9b3I736Y";
    public ChannelYouTube findChannel(String id){
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet&id=" + id + "&key=" + token;

        HttpHeaders headers= new HttpHeaders();
        headers.set("X-goog-api-key", token);

        HttpEntity<ChannelSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);

        assert response.getBody() != null;
        return response.getBody().getItems().get(0);
    }

}
