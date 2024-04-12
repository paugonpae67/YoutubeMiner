package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.Channel;
import AISS.YouTubeMiner.model.youtube.channel.ChannelSearch;
import AISS.YouTubeMiner.model.youtube.channel.ChannelSnippet;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    public final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";

        public Channel findChannel(String name){
        String uri = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet&forUsername=" + name + "&key=" + token;

        HttpHeaders headers= new HttpHeaders();
        headers.set("X-goog-api-key", token);

        HttpEntity<ChannelSearch> request = new HttpEntity<>(null,headers);
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);

        assert response.getBody() != null;
        return response.getBody().getItems().get(0);
    }

}
