package com.services;

import com.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User getUserById(int userId);
    void deleteUser(int userId);
}
