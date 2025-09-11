package ms.controllers;


import ms.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
