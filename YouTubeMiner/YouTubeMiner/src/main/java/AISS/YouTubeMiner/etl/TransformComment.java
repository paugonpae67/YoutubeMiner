package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.User;
import AISS.YouTubeMiner.model.youtube.comment.CommentSnippet;

public class TransformComment {

    public static Comment transformComment(CommentSnippet comment){
        Comment commentFinal= new Comment();
        commentFinal.setId(comment.getTopLevelComment().getId());

        User autorFinal= new User();
        autorFinal.setName(comment.getTopLevelComment().getSnippet().getAuthorDisplayName());
        autorFinal.setUser_link(comment.getTopLevelComment().getSnippet().getAuthorChannelUrl());
        autorFinal.setPicture_link(comment.getTopLevelComment().getSnippet().getAuthorProfileImageUrl());
        commentFinal.setAuthor(autorFinal);

        commentFinal.setText(comment.getTopLevelComment().getSnippet().getTextOriginal());
        commentFinal.setCreatedOn(comment.getTopLevelComment().getSnippet().getPublishedAt());
        return commentFinal;

    }
}
