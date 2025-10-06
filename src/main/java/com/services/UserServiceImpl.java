package com.services;

import com.dao.UserDAO;
import com.exceptions.UserNotFoundException;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User existing = getUserById(user.getId());
        userDAO.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int userId) {
        return userDAO.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        User user = getUserById(userId);
        userDAO.deleteUser(user);
    }
}
