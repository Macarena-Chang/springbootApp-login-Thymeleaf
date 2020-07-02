package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    //Hacer gets para mapear el index y el user-form
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //http://localhost:8080//userForm
    @GetMapping("/userForm")
    public String getUserForm(){
        return "user-form/user-view";
    }
}