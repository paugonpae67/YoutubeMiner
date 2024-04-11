package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService service;
    @Test
    @DisplayName("Get a video")
    void findVideos() {
        VideoSnippet video= service.findVideos();
        System.out.println("Funciona "+ video);

    }
}