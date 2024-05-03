package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Channel;
import AISS.YouTubeMiner.model.videominer.Video;
import AISS.YouTubeMiner.model.youtube.channel.ChannelYouTube;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;

import java.util.LinkedList;
import java.util.List;

public class TransformChannel {

    public static Channel transformChannel(ChannelYouTube channelYouTube){
        Channel channelFinal= new Channel();
        channelFinal.setId(channelYouTube.getId());
        channelFinal.setDescription(channelYouTube.getSnippet().getDescription());
        channelFinal.setName(channelYouTube.getSnippet().getTitle());
        channelFinal.setCreatedTime(channelYouTube.getSnippet().getPublishedAt());
        channelFinal.setVideos(parseoVideos(channelYouTube.getVideos()));
        return channelFinal;
    }

    private static List<Video> parseoVideos(List<VideoSnippet> videos) {
        List<Video> listaVideo = new LinkedList<>();
        for(VideoSnippet v:videos){
            Video videoFinal= TransformVideo.transformVideo(v);
            listaVideo.add(videoFinal);
        }
        return listaVideo;
    }
}
