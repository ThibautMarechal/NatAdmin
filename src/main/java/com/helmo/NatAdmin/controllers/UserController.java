package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController
{

    private UserService userService;

    public UserController()
    {
        this.userService = new UserService();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users/all";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") Long id, Model model){
        User u = userService.getById(id);
        model.addAttribute("user", u);
        return "users/view";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String edit(@PathVariable("id") Long id, Model model){
        return "{form-status: true}";
    }
}
