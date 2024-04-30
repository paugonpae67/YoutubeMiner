package AISS.YouTubeMiner.model.youtube.videoSnippet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceId {

    @JsonProperty("videoId")
    private String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "ResourceId{" +
                "videoId='" + videoId + '\'' +
                '}';
    }
}
