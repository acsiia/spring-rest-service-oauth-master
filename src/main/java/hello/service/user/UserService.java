package hello.service.user;



import hello.data.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void deleteUser(long id);
    User updateUser(User user);
    boolean isLoginFree(String login);
    User getUserByEmail(String email);
    User getUserById(Integer id);
    List<User> getListOfUsers();
    User getUserByLoginAndPassword(String username, String password);
    //void setCommentSendersNames(List<Comment> comments);
    //void setPostSendersUsernames(List<Post> posts);
    List<User> findByPattern(String pattern);
    User changeEnableField(Integer id);
}
