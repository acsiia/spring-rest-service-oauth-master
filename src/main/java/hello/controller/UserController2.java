package hello.controller;

import hello.data.User;
import hello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController2 {

    @Autowired
    private UserService userService;


    @RequestMapping("/current")
    public User userPageCurrent(@AuthenticationPrincipal User user) {
        return  user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User userPage(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return user;
    }


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        if(userService.isLoginFree(user.getLogin()))
            return userService.saveUser(user);
    //not final code, course it must return not null, but a json in the else case
        else
            return null;
    }


    @RequestMapping(value = "/loginFree/{login}", method = RequestMethod.GET)
    @ResponseBody
    public boolean isLoginFree(@PathVariable("login") String login) {
        return userService.isLoginFree(login);
    }


}
