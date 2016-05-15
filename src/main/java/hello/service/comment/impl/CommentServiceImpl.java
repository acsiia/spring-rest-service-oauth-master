package hello.service.comment.impl;


import hello.data.Comment;
import hello.repository.CommentRepository;
import hello.repository.PostRepository;
import hello.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private PostRepository postRepository;

    public CommentServiceImpl() {
    }

    @Override
    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        Comment comment = getComment(id);
        repository.delete(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
       return repository.save(comment);
    }

    @Override
    public Comment getComment(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Comment> getListOfCommentsByPostId(Integer id) {
        return repository.findByPost(postRepository.findByPostId(id));
    }


}
