package hello.controller;


import hello.data.Post;
import hello.data.User;
import hello.service.post.PostService;
import hello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public List<Post> showPostCurrent(@AuthenticationPrincipal User user) {
 //REMAKE!!!!!!!!!!!!!!
        return postService.getListOfPostsByIdOfOwner(user.getId());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Post> showPosts() {
        List<Post> posts = postService.getListOfPosts();
        return posts;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
        public Post addPost(@RequestBody Post post,@AuthenticationPrincipal User user){

        post.setDislike(0);
        post.setLike(0);
        post.setOwner(user);
        post.setPostTime(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
        return postService.savePost(post);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void removePost(@PathVariable("id") Integer id,@AuthenticationPrincipal User user) {
        Post post = postService.getPost(id);
        if (post.getOwner().getLogin().equals(user.getLogin()))
        {
            postService.deletePost(id);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Post updatePost(@RequestBody Post post, @AuthenticationPrincipal User user) {
        Post post1 = postService.getPost(post.getPostId());

        if (post1.getOwner().getLogin().equals(user.getLogin()))
        {
            post1.setDislike(post.getDislike());
            post1.setLike(post.getLike());
            post1.setImage(post.getImage());
            post1.setPostContent(post.getPostContent());

            return postService.updatePost(post1);
        }
        return null;
    }


}
