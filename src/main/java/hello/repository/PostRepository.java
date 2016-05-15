package hello.repository;


import hello.data.Post;
import hello.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByPostId(Integer id);
    List<Post> findByOwner (User user);
}
