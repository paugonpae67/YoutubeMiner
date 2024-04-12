package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService service;
    @Test
    @DisplayName("Get a video")
    void findVideos() {
        List<VideoSnippet> videos= service.findVideos("Ks-_Mh1QhMc");
        System.out.println(videos);

    }
}