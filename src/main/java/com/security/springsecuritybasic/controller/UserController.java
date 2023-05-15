package com.security.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/user-homepage")
    public String userHomepage(){
        return "this is the user language !!";
    }

    @GetMapping("/feed")
    public String userFeed(){
        return "This is the user feed !!";
    }
}
