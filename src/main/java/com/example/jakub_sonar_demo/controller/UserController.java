package com.example.jakub_sonar_demo.controller;

import com.example.jakub_sonar_demo.model.User;
import com.example.jakub_sonar_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService = new UserService();

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/error")
    public String triggerBug() {
        String s = null;
        return s.toString();
    }

    public String check(String input) {
        if (input == "test") {
            return "A";
        } else if (input.equals("test")) {
            return "B";
        }
        return "C";
    }
}
