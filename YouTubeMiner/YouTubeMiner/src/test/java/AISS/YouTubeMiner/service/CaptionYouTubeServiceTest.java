package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.caption.CaptionYouTube;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CaptionYouTubeServiceTest {
    @Autowired
    CaptionService service;
    @Test
    @DisplayName("Get captions from a video id")
    void findCaptionsFromVideo() {
        String prueba =  "_VB39Jo8mAQ";
        List<CaptionYouTube> captionYouTubes = service.findCaptionsFromVideo(prueba);
        System.out.println("Funciono + " + captionYouTubes.toString() + " ;)");
    }
}