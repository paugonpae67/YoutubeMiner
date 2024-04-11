package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.comment.Comment;
import AISS.YouTubeMiner.model.youtube.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;

    public final static String token = "AIzaSyDXPg4TzNK6g0cl3c3MWC5_k5Sq1JynN94";

    public List<Comment> findCommentsFromVideoId(String videoId){
        String uri = "https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=" + videoId+"&key=" + token;
        CommentSearch comments = restTemplate.getForObject(uri, CommentSearch.class);
        assert comments != null;
        return comments.getItems();
    }
}
