package com.services;


import com.dao.UserDaoImpl;
import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDaoImpl userDao;


    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
   }


@Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
@Override
    public void addUser(User user){
        userDao.addUser(user);
    }




}
