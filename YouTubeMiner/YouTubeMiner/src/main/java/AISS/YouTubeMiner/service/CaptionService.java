package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.caption.Caption;
import AISS.YouTubeMiner.model.youtube.caption.CaptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;

    public final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";

    public List<Caption> findCaptionsFromVideo(String videoId){
        String uri = "https://youtube.googleapis.com/youtube/v3/captions?part=snippet&videoId=" + videoId +"&key=" + token;
        CaptionSearch caption = restTemplate.getForObject(uri, CaptionSearch.class);
        assert caption != null;
        return caption.getItems();
    }

}
