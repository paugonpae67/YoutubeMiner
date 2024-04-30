package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Caption;
import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.User;
import AISS.YouTubeMiner.model.videominer.Video;
import AISS.YouTubeMiner.model.youtube.videoSnippet.VideoSnippet;

import java.util.LinkedList;
import java.util.List;

public class TransformVideo {

    public static Video transformVideo(VideoSnippet video){
        Video videoFinal= new Video();
        videoFinal.setId(video.getSnippet().getResourceId().getVideoId());
        videoFinal.setName(video.getSnippet().getTitle());
        videoFinal.setDescription(video.getSnippet().getDescription());
        videoFinal.setReleaseTime(video.getSnippet().getPublishedAt());
        videoFinal.setComments(parseoComment(video));
        videoFinal.setCaptions(parseoCaption(video));

        return videoFinal;

    }

    private static List<Caption> parseoCaption(VideoSnippet video) {

        List<Caption> listaCaption= new LinkedList<>();

        for(int i=0; i< video.getCaptions().size(); i++){
            Caption captionFinal= TransformCaption.transformCaption(video.getCaptions().get(i));
            listaCaption.add(captionFinal);
        }
        return listaCaption;
    }

    private static List<Comment> parseoComment(VideoSnippet video){
        List<Comment> listaComment= new LinkedList<>();
        for(int i=0; i<video.getComments().size(); i++){
            Comment commentFinal = TransformComment.transformComment(video.getComments().get(i));
            listaComment.add(commentFinal);
        }
        return listaComment;
    }
}
