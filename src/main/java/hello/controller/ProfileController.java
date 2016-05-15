package hello.controller;


import hello.data.Profile;
import hello.data.User;
import hello.repository.UserRepository;
import hello.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserRepository userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Profile showProfileCurrent(@AuthenticationPrincipal User user) {
        Profile profile = user.getProfile();
        return profile;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Profile showProfile(@PathVariable("id") Integer userId) {
        Profile profile = profileService.getProfileByUserId(userId);
        return profile;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Profile updateProfile(@RequestBody Profile profile,@AuthenticationPrincipal User user) throws IOException {
        Profile profile1 = user.getProfile();
        profile1.setAvatar(profile.getAvatar());
        profile1.setBirthday(profile.getBirthday());
        profile1.setCity(profile.getCity());
        profile1.setCountry(profile.getCountry());
        profile1.setFirstName(profile.getFirstName());
        profile1.setSecondName(profile.getSecondName());
        profile1.setSurname(profile.getSurname());
        profile1.setSex(profile.getSex());
        return profileService.updateProfile(profile1);
    }

}
