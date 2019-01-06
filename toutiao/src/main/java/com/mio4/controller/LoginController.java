package com.mio4.controller;

import com.mio4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register/",method = {RequestMethod.GET,RequestMethod.POST})
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam(value = "rember", defaultValue = "0") int remeberme){
        userService.addUser(username,password);
    }
}
