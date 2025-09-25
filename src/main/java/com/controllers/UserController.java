package com.controllers;


import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // ЗДЕСЬ ЧЕРЕЗ СЕРВИС

    //private final UserDao userDao;

//    @Autowired
//    public UserController(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Autowired
    private UserService userService;




    @GetMapping("/userAll")
    public String GetAllUser(Model model) {
        System.out.println("users size = " + userService.getAllUsers().size());
        model.addAttribute("users", userService.getAllUsers());

        return "user/userMainPage";
    }

    @RequestMapping(value = "/addNewUser")
    public String AddNewUser(Model model) {

    User user = new User();
    model.addAttribute("user", user);
        return "user/userInfoPage";
    }

    @RequestMapping(value = "/saveUser")
    public String SaveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/userAll";
    }

    @RequestMapping(value = "/updateUser")
    public String UpdateUser(@RequestParam("userId")  int userId, Model model) {

        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user/userInfoPage";

    }
    @RequestMapping("deleteUser")
    public String DeleteUser(@RequestParam("userId")  int userId, Model model) {
        userService.deleteUser(userId);
        return  "redirect:/userAll";
    }

}
