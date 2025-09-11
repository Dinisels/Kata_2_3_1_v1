package com.controllers;


import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/userAll")
    public String GetAllUser() {

        //model.addAttribute("users", userDao.getAllUsers());

        return "user/userMainPage";
    }



}
