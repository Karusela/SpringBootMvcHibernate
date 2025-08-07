package com.karusela.springmvc.SpringBootMvcHibernate.controller;

import com.karusela.springmvc.SpringBootMvcHibernate.entity.User;
import com.karusela.springmvc.SpringBootMvcHibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String showUsers(ModelMap model) {

        List<User> result = userService.getAllUsers();
        model.addAttribute("result", result);

        return "index";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping(value = "/updateInfo")
    public String updateUser(@RequestParam("userid") int id, Model model) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userid") int id, Model model) {

        userService.deleteUser(id);

        return "redirect:/";
    }
}