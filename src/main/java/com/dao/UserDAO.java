package com.dao;

import com.model.User;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User getUserById(int userId);
    void deleteUser(int userId);
}