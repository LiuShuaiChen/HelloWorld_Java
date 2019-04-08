package com.pancm.web;


import com.pancm.bean.User;
import com.pancm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    private int count = 9000;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean adduser(@RequestBody User user) {
        System.out.println("add user ...");
        count = ++count;
        user.setId(count);
        user.setAge(user.getAge() + count);
        user.setName(user.getName() + count);

        return userService.addUser(user);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUser(@RequestBody User user) {
        System.out.println("update  user ...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/del", method = RequestMethod.DELETE)
    public boolean delUser(@RequestParam(value = "username", required = true) int id) {
        System.out.println("delete user ...");
        return userService.delUser(id);
    }

    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<User> getAll() {
        System.out.println("get all user ...");
        return userService.findAll();
    }


}
