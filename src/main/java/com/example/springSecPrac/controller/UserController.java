package com.example.springSecPrac.controller;

import com.example.springSecPrac.entity.Users;
import com.example.springSecPrac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/register")
    public Users registare(@RequestBody Users user){

        return service.register(user);

    }


    @PostMapping("/login")
    public String login(@RequestBody Users user){
      //  System.out.println(user);
        //return "success";
        return service.verify(user);
    }

}
