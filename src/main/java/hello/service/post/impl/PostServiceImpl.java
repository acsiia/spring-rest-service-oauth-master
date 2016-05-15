package hello.service.post.impl;


import hello.data.Post;
import hello.data.User;
import hello.repository.PostRepository;
import hello.repository.UserRepository;
import hello.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private UserRepository userRepository;

    public PostServiceImpl() {
    }

    @Override
    public Post savePost(Post post) {
        return  repository.save(post);
    }

    @Override
    public void deletePost(Integer id) {
        Post post = getPost(id);
        repository.delete(post);
    }

    @Override
    public Post updatePost(Post post) {
        return repository.save(post);
    }

    @Override
    public Post getPost(Integer id) {
        return repository.findByPostId(id);
    }

    @Override
    public List<Post> getListOfPosts() {
        return (List<Post>) repository.findAll();
    }

    @Override
    public List<Post> getListOfPostsByIdOfOwner(Integer id) {
        User user = userRepository.findById(id);
        return repository.findByOwner(user);
    }

   }
