package AISS.YouTubeMiner.controller;

import AISS.YouTubeMiner.etl.TransformCaption;
import AISS.YouTubeMiner.etl.TransformChannel;
import AISS.YouTubeMiner.etl.TransformComment;
import AISS.YouTubeMiner.etl.TransformVideo;
import AISS.YouTubeMiner.model.videominer.Caption;
import AISS.YouTubeMiner.model.videominer.Channel;
import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.Video;
import AISS.YouTubeMiner.service.CaptionService;
import AISS.YouTubeMiner.service.ChannelService;
import AISS.YouTubeMiner.service.CommentService;
import AISS.YouTubeMiner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
@RestController
@RequestMapping("/api/youtube/v3/channels")
public class ChannelController {

    @Autowired
    ChannelService channelService;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;
    
    
    @GetMapping("/{forUsername}")
    public Channel findChannel(@PathVariable String forUsername){
        AISS.YouTubeMiner.model.youtube.channel.Channel channelYoutube = channelService.findChannel(forUsername);
        Channel channel= TransformChannel.transformChannel(channelYoutube);

        List<AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet> videosYoutube = videoService.findVideos(forUsername);
        List<Video> videos = new LinkedList<>();

        for(AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet videoYoutube:videosYoutube){
            Video video= TransformVideo.transformVideo(videoYoutube);
            //List<Comment> comentarios = commentService.findCommentsFromVideoId(videoYoutube.getId().getVideoId()).stream().map(TransformComment::transformComment).toList();
            //video.setComments(comentarios);
            //List<Caption> captions= captionService.findCaptionsFromVideo(videoYoutube.getId().getVideoId()).stream().map(TransformCaption::transformCaption).toList();
            //video.setCaptions(captions);
            videos.add(video);
        }
        channel.setVideos(videos);
        return channel;
    }

    @PostMapping("/{forUsername}")
    public void postChannel(@PathVariable String forUsername){
        Channel channel=findChannel(forUsername);
    }
 
}
