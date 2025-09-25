package com.services;


import com.dao.UserDaoImpl;
import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDaoImpl userDao;


    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
   }


@Override
@Transactional
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    @Override
    @Transactional
    public void saveUser(User user){
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }


}
