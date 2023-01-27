package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/")
    public String showAllUser (Model model ){
        List<User> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/{id}")
    public String getUsetById(@PathVariable("id") int id, Model model){
        model.addAttribute("user",userService.getUserById(id));
        return "user-id";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
//        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user){
        userService.updUser(user, id);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public String delUser(@PathVariable("id") int id){
        userService.delUser(id);
        return "redirect:/";
    }

}
