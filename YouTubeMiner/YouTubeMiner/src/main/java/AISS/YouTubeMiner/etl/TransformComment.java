package AISS.YouTubeMiner.etl;

import AISS.YouTubeMiner.model.videominer.Comment;
import AISS.YouTubeMiner.model.videominer.User;
import AISS.YouTubeMiner.model.youtube.comment.CommentSnippet;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TransformComment {
    private static Long num = 0L;
    private static Map<Long, String> map = new HashMap<>();

    public static Comment transformComment(AISS.YouTubeMiner.model.youtube.comment.Comment comment){
        Comment commentFinal= new Comment();
        commentFinal.setId(comment.getCommentSnippet().getTopLevelComment().getId());

        // Generamos un map clave valor que asocia cada authorId (String) una clave (Long) correspondiente en VideoMiner
        String authorId = comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelId().getValue();

        num++;
        map.put(num, authorId);
        long[] x= map.entrySet().stream().filter(pareja -> pareja.getValue().equals(authorId)).mapToLong(c-> c.getKey()).toArray();

        User autorFinal= new User();
        autorFinal.setId(x[0]);
        autorFinal.setName(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName());
        autorFinal.setUser_link(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl());
        autorFinal.setPicture_link(comment.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl());
        commentFinal.setAuthor(autorFinal);

        commentFinal.setText(comment.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal());
        commentFinal.setCreatedOn(comment.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt());
        return commentFinal;

    }

}
