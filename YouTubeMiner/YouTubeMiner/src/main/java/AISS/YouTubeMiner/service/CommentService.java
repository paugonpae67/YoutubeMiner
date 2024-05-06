package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.exception.DisableCommentException;
import AISS.YouTubeMiner.model.youtube.comment.CommentYouTube;
import AISS.YouTubeMiner.model.youtube.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;

    private final static String token = "AIzaSyBuOr1tTp7kcvBLNjQ3M4aBJ0R9b3I736Y";

    public List<CommentYouTube> findCommentsFromVideoId(String videoId, Integer maxComments) throws DisableCommentException {
        try{
            String uri = "https://youtube.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=" + videoId+"&maxResults="+maxComments+"&key=" + token;
            HttpHeaders headers= new HttpHeaders();
            headers.set("X-goog-api-key", token);

            HttpEntity<CommentSearch> request = new HttpEntity<>(null,headers);
            ResponseEntity<CommentSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentSearch.class);

            if(response.hasBody()) {
                return response.getBody().getItems();
            }else{
                return new LinkedList<>();
            }
        }catch (Exception e){
            throw new DisableCommentException();
        }

    }
}
