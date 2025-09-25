package com.services;

import com.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUserById(int userId);
    public void deleteUser(int userId);
}
