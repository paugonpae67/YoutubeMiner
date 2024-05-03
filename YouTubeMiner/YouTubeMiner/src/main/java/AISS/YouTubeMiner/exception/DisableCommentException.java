package AISS.YouTubeMiner.exception;

import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.youtube.comment.CommentYouTube;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "comments are disable")
public class DisableCommentException extends Exception {
    public List<CommentYouTube> DisableCommentException(){
        return new ArrayList<CommentYouTube>();
    }
}
