package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Channel;
import AISS.YouTubeMiner.model.videominer.Video;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;

import java.util.LinkedList;
import java.util.List;

public class TransformChannel {

    public static Channel transformCaption(AISS.YouTubeMiner.model.youtube.channel.Channel channel){
        Channel channelFinal= new Channel();
        channelFinal.setId(channel.getId());
        channelFinal.setDescription(channel.getSnippet().getDescription());
        channelFinal.setName(channel.getSnippet().getTitle());
        channelFinal.setCreatedTime(channel.getSnippet().getPublishedAt());
        channelFinal.setVideos(parseoVideos(channel.getVideos()));
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
