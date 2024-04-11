package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.ChannelSearch;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;
    private final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";

    public VideoSnippet findVideos(){
        String uri= "https://youtube.googleapis.com/youtube/v3/videos?part=snippet&id=Ks-_Mh1QhMc&key=" + token;
        VideoSnippetSearch video=restTemplate.getForObject(uri, VideoSnippetSearch.class);
            assert video != null;
            return video.getItems().get(0);
    }

}
