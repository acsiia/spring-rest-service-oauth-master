package hello.service.user.impl;


import hello.data.Profile;
import hello.data.Role;
import hello.data.User;
import hello.repository.ProfileRepository;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;
import hello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public UserServiceImpl() {
    }

    @Override
    public List<User> getListOfUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public void deleteUser(long id) {
        repository.delete(id);
    }

    @Override
    public User changeEnableField(Integer id) {

        User user = repository.findById(id);
        if(user.isEnable()){
            user.setEnable(false);
          //  user.setRoles(null);
        } else {
            user.setEnable(true);
//            Role role = roleRepository.findById(1);
//            Set<Role> roles =new HashSet<Role>();
//            roles.add(role);
//            user.setRoles(roles);
        }
        updateUser(user);
        return user;
    }

    @Override
    public User saveUser(User user) {

        Role role = roleRepository.findById(1);
        Set<Role> roles =new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setEnable(true);
        User user1 = repository.save(user);

        Profile profile = new Profile();
        profile.setUser(user);
        profileRepository.save(profile);

        user1.setProfile(profile);
        return user1;
    }


    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public boolean isLoginFree(String login) {
        if(repository.findByLogin(login) == null)
            return true;
        else
            return false;
    }

//    @Override
//    public IsFree getUserByLogin(String login) {
//        if (repository.findByLogin(login) != null) {
//            return new IsFree(false);
//        }
//        return new IsFree(true);
//    }

    @Override
    public User getUserByEmail(String email) {
        User user=repository.findByEmail(email);
        return user;
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User getUserByLoginAndPassword(String username, String password) {
        return repository.findByLoginAndPassword(username, password);
    }

//    @Override
//    public void setCommentSendersNames(List<Comment> comments) {
//
//    }
//
//    @Override
//    public void setPostSendersUsernames(List<Post> posts) {
//
//    }

    @Override
    public List<User> findByPattern(String pattern) {
        return null;
    }


}
