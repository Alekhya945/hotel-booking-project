package com.abc.userservice.service;

import java.util.List;

import com.abc.userservice.entity.User;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void removeUser(int userId);
    List<User> getAllUsers();
    User getUserById(int userId);
}
