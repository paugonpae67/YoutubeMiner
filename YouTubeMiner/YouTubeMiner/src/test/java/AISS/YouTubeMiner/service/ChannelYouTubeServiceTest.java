package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.ChannelYouTube;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChannelYouTubeServiceTest {

    @Autowired
    ChannelService service;

    @Test
    @DisplayName("Get a channel")
    void findChannel() {
        ChannelYouTube channelYouTube = service.findChannel("GoogleDevelopers");
        System.out.println("Funciono + " + channelYouTube + " :)");
    }
}