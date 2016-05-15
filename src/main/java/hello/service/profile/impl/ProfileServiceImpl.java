package hello.service.profile.impl;


import hello.data.Profile;
import hello.data.User;
import hello.repository.ProfileRepository;
import hello.repository.UserRepository;
import hello.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private UserRepository userRepository;

    public ProfileServiceImpl() {
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return repository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        repository.delete(id);
    }

    @Override
    public Profile updateProfile(Profile profile) {
       return repository.save(profile);
    }

    @Override
    public Profile getProfileById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Profile getProfileByUserId(Integer userId) {
        User user = userRepository.findById(userId);
        return repository.findByUser(user);
    }

//    @Override
//    public Profile getProfileByUserId(long id) {
//        return repository.findByUser(userRepository.findById(id));
//    }

    @Override
    public List<Profile> getListOfProfiles() {
        return (List<Profile>) repository.findAll();
    }

//    @Override
//    public void setPostSendersProfiles(List<Post> posts) {
//
//    }
}
