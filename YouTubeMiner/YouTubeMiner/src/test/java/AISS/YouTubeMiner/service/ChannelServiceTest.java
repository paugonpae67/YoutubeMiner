package AISS.YouTubeMiner.service;

import AISS.YouTubeMiner.model.youtube.channel.Channel;
import AISS.YouTubeMiner.model.youtube.channel.ChannelSearch;
import AISS.YouTubeMiner.model.youtube.channel.ChannelSnippet;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService service;

    @Test
    @DisplayName("Get a channel")
    void findChannel() {
        Channel channel = service.findChannel("GoogleDevelopers");
        System.out.println("Funciono + " + channel + " :)");
    }

    @Test
    @DisplayName("Get videos from a channel")
    void findVideosChannel(String name) {
        List<VideoSnippet> lista = service.findVideosChannel(name);
        System.out.println("Funciono + " + lista + " ;)");
    }


}