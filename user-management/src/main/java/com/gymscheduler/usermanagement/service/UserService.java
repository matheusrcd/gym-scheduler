package com.gymscheduler.usermanagement.service;

import com.gymscheduler.usermanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUser(String username);
    long deleteUser(String username);
}