package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get comments from a video")
    void findCommentsFromVideoId() {
        String prueba =  "_VB39Jo8mAQ";
        List<Comment> comments = service.findCommentsFromVideoId(prueba);
        System.out.println("Funciono + " + comments.toString() + " :)");
    }
}