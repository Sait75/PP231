package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private final UserService userService;

    public UsersController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }
    @GetMapping(value = "/")
    public String showAllUser (Model model ){
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }
}
