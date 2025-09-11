package com.services;


import com.dao.UserDao;
import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;


    public UserService(UserDao userDao) {
        this.userDao = userDao;
   }



    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public void addUser(User user){
        userDao.addUser(user);
    }




}
