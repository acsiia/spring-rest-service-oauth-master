package hello.controller;

import hello.data.Comment;
import hello.data.Post;
import hello.data.User;
import hello.service.comment.CommentService;
import hello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment,@AuthenticationPrincipal User user) {
        comment.setSender(user);
        return commentService.saveComment(comment);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void removeComment(@PathVariable("id") Integer id, @AuthenticationPrincipal User user) {
        if(commentService.getComment(id).getSender().getLogin().equals(user.getLogin()))
          commentService.deleteComment(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Comment updateComment (@RequestBody Comment comment, @AuthenticationPrincipal User user) {
        Comment comment1 = commentService.getComment(comment.getId());

        if (comment1.getSender().getLogin().equals(user.getLogin()))
        {
            comment1.setComment(comment.getComment());
            return commentService.updateComment(comment1);
        }
        return null;
    }

    @RequestMapping(value = "/getByPost/{id}", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable("id") Integer id, @AuthenticationPrincipal User user) {
        List<Comment> comments = commentService.getListOfCommentsByPostId(id);
        return comments;
    }


}
