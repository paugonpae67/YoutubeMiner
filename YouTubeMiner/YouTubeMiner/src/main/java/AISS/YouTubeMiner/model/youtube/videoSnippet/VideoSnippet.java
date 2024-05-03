package AISS.YouTubeMiner.model.youtube.videoSnippet;


import AISS.YouTubeMiner.model.youtube.caption.CaptionYouTube;
import AISS.YouTubeMiner.model.youtube.comment.CommentYouTube;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoSnippet {

    @JsonProperty("id")
    private VideoSnippetId id;
    @JsonProperty("snippet")
    private VideoSnippetDetails snippet;

    // These attributes have been manually added
    @JsonProperty("comments")
    private List<CommentYouTube> commentYouTubes;

    @JsonProperty("captions")
    private List<CaptionYouTube> captionYouTubes;

    public VideoSnippet() {
        this.commentYouTubes = new ArrayList<>();
        this.captionYouTubes = new ArrayList<>();
    }

    @JsonProperty("comments")
    public List<CommentYouTube> getComments() {
        return commentYouTubes;
    }

    @JsonProperty("comments")
    public void setComments(List<CommentYouTube> commentYouTubes) {
        this.commentYouTubes = commentYouTubes;
    }

    @JsonProperty("captions")
    public List<CaptionYouTube> getCaptions() { return captionYouTubes; }

    @JsonProperty("captions")
    public void setCaptions(List<CaptionYouTube> captionYouTubes) {
        this.captionYouTubes = captionYouTubes;
    }

    @JsonProperty("id")
    public VideoSnippetId getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(VideoSnippetId id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public VideoSnippetDetails getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(VideoSnippetDetails snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoSnippet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("snippet");
        sb.append('=');
        sb.append(((this.snippet == null)?"<null>":this.snippet));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
