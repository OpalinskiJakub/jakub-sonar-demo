package com.example.jakub_sonar_demo.service;

import com.example.jakub_sonar_demo.model.User;

import java.util.*;
import java.util.logging.Logger;

public class UserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

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

    public User getUserByIndex(int index) {
        List<User> list = new ArrayList<>(userMap.values());
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    public String riskyLogic() {
        String result = "default";
        return result.toLowerCase();
    }

    public void printUser(String id) {
        User user = userMap.get(id);
        if (user != null) {
            LOGGER.info("User: " + user.getName());
        }
    }

    public void logicalBug() {
        boolean a = true;
        boolean b = true;
        if (a || b) {
            LOGGER.info("This will always be true");
        }
    }

    public void unsafeCast() {
        Object obj = "42";
        try {
            Integer x = Integer.parseInt((String) obj);
            LOGGER.info("Parsed int: " + x);
        } catch (NumberFormatException e) {
            LOGGER.warning("Cast failed: " + e.getMessage());
        }
    }
}
