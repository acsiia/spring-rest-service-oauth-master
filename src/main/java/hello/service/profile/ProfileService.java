package hello.service.profile;


import hello.data.Profile;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile);
    void deleteProfile(Long id);
    Profile updateProfile(Profile profile);
    Profile getProfileById(Integer id);
    Profile getProfileByUserId(Integer userId);
    List<Profile> getListOfProfiles();
  //  void setPostSendersProfiles(List<Post> posts);
}
