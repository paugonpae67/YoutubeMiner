package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.caption.Caption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CaptionServiceTest {
    @Autowired
    CaptionService service;
    @Test
    @DisplayName("Get captions from a video id")
    void findCaptionsFromVideo() {
        String prueba =  "_VB39Jo8mAQ";
        List<Caption> captions = service.findCaptionsFromVideo(prueba);
        System.out.println("Funciono + " + captions.toString() + " ;)");
    }
}