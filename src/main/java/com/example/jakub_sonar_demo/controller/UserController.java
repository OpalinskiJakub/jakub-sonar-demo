package com.example.jakub_sonar_demo.controller;

import com.example.jakub_sonar_demo.model.User;
import com.example.jakub_sonar_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "static string";
    }

    @GetMapping("/try")
    public String riskyEndpoint() {
        try {
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            return "Division by zero error";
        }
        return "ok";
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
        System.out.printf("Name: %s, Age: %d%n", "Alice", 30);
        return 1;
    }
}
