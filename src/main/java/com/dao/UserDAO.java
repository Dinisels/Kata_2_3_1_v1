package com.dao;

import com.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUserById(int userId);
    public void deleteUser(int userId);
}
