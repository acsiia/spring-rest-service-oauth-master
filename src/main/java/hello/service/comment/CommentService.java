package hello.service.comment;


import hello.data.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    void deleteComment(Integer id);
    Comment updateComment(Comment comment);
    Comment getComment(Integer id);
    List<Comment> getListOfCommentsByPostId(Integer id);
}
