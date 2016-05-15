package hello.controller;


import hello.data.User;
import hello.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> adminPage() {
        List<User> userList = userService.getListOfUsers();
        return userList;
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }


    @RequestMapping(value = "/banUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public boolean banUser(@PathVariable("id") Integer id) {
        return userService.changeEnableField(id).isEnable();
    }


}
