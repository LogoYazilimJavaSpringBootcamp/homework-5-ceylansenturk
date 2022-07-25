package com.java.moviereviewsite.controller;

import com.java.moviereviewsite.model.User;
import com.java.moviereviewsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/sign-up")
    public User signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email){
        return userService.signUp(username,password,email);

    }



    @GetMapping(value = "/sign-in")
    public User signIn(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       @RequestParam("email") String email){
       return userService.signIn(username,password,email);
    }

    @PutMapping(value= "/update")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

}
