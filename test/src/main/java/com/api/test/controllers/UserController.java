package com.api.test.controllers;

import com.api.test.models.UserModel;
import com.api.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public UserModel createUser(@PathVariable Long id, @RequestBody UserModel dataToUser) {
        UserModel user = userService.findUserById(id);

        if (user != null) {
            return userService.updateUser(user, dataToUser);
        }
        return null;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserModel user = userService.findUserById(id);

        if (user != null) {
            userService.deleteUser(user);
            return "Success: User deleted!";
        }
        return "Error";
    }
}
