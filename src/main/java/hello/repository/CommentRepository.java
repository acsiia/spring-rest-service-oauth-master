package hello.repository;


import hello.data.Comment;
import hello.data.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findById(Integer id);
    List<Comment> findByPost(Post post);
}
