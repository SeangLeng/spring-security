package com.security.springsecuritybasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // controller works with view engine
    @GetMapping("/homepage")
    @ResponseBody
    public String adminHomepage(){
        return "This is the admin page";
    }
    @GetMapping("/feed")
    @ResponseBody
    public String adminFeed(){
        return "This is the admin feed page";
    }
}
