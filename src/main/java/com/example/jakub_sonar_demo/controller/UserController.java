package com.example.jakub_sonar_demo.controller;

import com.example.jakub_sonar_demo.model.User;
import com.example.jakub_sonar_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

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
        return "static string";
    }

    @GetMapping("/bug1")
    public int arrayBug() {
        int[] arr = new int[2];
        if (arr.length > 5) {
            return arr[5];
        }
        return -1;
    }

    @GetMapping("/bug2")
    public boolean wrongStringCompare(@RequestParam String input) {
        return "admin".equals(input);
    }

    @GetMapping("/bug3")
    public int formatBug() {
        LOGGER.info(String.format("Name: %s, Age: %d", "Alice", 30));
        return 1;
    }
}
