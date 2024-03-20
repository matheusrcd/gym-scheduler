package com.gymscheduler.usermanagement.service;

import com.gymscheduler.usermanagement.model.User;
import com.gymscheduler.usermanagement.repository.UserRepository;
import com.gymscheduler.usermanagement.utils.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(@RequestBody User user) {
        user.setPassword(PasswordEncoderUtil.encodePassword(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public long deleteUser(String username) {
        return userRepository.deleteByUsername(username);
    }
}