package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get a video")
    void findVideos() {
        String prueba ="Ks-_Mh1QhMc";
        VideoSnippet video= service.findVideos(prueba);
        System.out.println("Funciona \n"+ video.toString());

    }
}