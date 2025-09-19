package com.dao;

import com.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public void addUser(User user);
}
