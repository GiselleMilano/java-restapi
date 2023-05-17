package com.api.test.controllers;

import com.api.test.models.UserModel;
import com.api.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(name = "/users")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }
}
