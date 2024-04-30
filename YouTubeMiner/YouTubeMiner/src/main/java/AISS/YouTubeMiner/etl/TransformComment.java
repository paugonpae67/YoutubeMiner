package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.User;
import AISS.YouTubeMiner.model.youtube.comment.CommentSnippet;

public class TransformComment {

    public static Comment transformComment(AISS.YouTubeMiner.model.youtube.comment.Comment comment){
        Comment commentFinal= new Comment();
        commentFinal.setId(comment.getCommentSnippet().getTopLevelComment().getId());

        User autorFinal= new User();
        autorFinal.setId(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelId().getValue());
        autorFinal.setName(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName());
        autorFinal.setUser_link(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl());
        autorFinal.setPicture_link(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl());
        commentFinal.setAuthor(autorFinal);

        commentFinal.setText(comment.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal());
        commentFinal.setCreatedOn(comment.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt());
        return commentFinal;

    }
}
