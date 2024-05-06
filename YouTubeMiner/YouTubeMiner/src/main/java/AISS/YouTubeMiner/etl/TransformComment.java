package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.User;
import AISS.YouTubeMiner.model.youtube.comment.CommentYouTube;

import java.util.HashMap;
import java.util.Map;

public class TransformComment {
    private static Long num = 0L;
    private static Map<Long, String> map = new HashMap<>();

    public static Comment transformComment(CommentYouTube commentYouTube){
        Comment commentFinal= new Comment();
        commentFinal.setId(commentYouTube.getCommentSnippet().getTopLevelComment().getId());

        String authorId = commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelId().getValue();

        User autorFinal= new User();
        autorFinal.setId(null);
        autorFinal.setName(commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName());
        autorFinal.setUser_link(commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl());
        autorFinal.setPicture_link(commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl());
        commentFinal.setAuthor(autorFinal);

        commentFinal.setText(commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal());
        commentFinal.setCreatedOn(commentYouTube.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt());
        return commentFinal;

    }

}
