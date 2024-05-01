package com.abc.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.userservice.dao.UserDao;
import com.abc.userservice.entity.User;
import com.abc.userservice.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public User addUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (!userDAO.existsById(user.getUserId())) {
            throw new ResourceNotFoundException("User not found with id: " + user.getUserId());
        }
        return userDAO.save(user);
    }

    @Override
    public void removeUser(int userId) {
        if (!userDAO.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        userDAO.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userDAO.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }
}
