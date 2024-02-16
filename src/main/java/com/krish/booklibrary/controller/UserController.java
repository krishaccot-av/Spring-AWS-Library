package com.krish.booklibrary.controller;

import com.krish.booklibrary.model.User;
import com.krish.booklibrary.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
