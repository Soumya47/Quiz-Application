package com.greenapex.quizApp.controllers;

import com.greenapex.quizApp.entities.User;
import com.greenapex.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*Adding User to the database*/
    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userService.addAndUpdateUser(user);
    }

    /*Get all the user from the database*/
    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.getAllUser();
    }
    /*Get the user by user id*/
    @GetMapping("user/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.getSpecificUser(userId);
    }

    /*Update the user by user id*/
    @PutMapping("/user/{userId}")
    public User updateUser(@RequestBody User user) {
        return userService.addAndUpdateUser(user);
    }

}
