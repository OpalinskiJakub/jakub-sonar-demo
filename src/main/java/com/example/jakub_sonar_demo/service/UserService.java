package com.example.jakub_sonar_demo.service;

import com.example.jakub_sonar_demo.model.User;

import java.util.*;

public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("1", new User("1", "Alice"));
        userMap.put("2", new User("2", "Bob"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUser(String id) {
        return userMap.get(id);
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public String riskyLogic() {
        String result = null;
        return result.toLowerCase();
    }
}
