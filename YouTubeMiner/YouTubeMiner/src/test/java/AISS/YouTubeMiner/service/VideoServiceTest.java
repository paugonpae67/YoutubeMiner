package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService service;

   /* @Test
    @DisplayName("Get videos from a channel")
    void findVideos() {
        String prueba ="Ks-_Mh1QhMc";
        List<VideoSnippet> video= service.findVideos("GoogleDevelopers");
        System.out.println("Funciona \n"+ video.toString());

    }*/
    @Test
    @DisplayName("Get ID of a playlist")
    void findId(){
        String res= service.getPlaylistId("GoogleDevelopers");
        System.out.println(res);
    }
}