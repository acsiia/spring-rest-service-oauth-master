package hello.service.post;


import hello.data.Post;

import java.util.List;

public interface PostService {
   Post savePost(Post post);
   void deletePost(Integer id);
   Post updatePost(Post post);
   Post getPost(Integer id);
   List<Post> getListOfPosts();
   List<Post> getListOfPostsByIdOfOwner(Integer id);
}
