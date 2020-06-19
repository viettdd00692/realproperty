package com.example.realproperty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "client/index";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "admin/403";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/houseforrent")
    public String houseforrent() {
        return "client/houseforrent";
    }

    @GetMapping("/houseforsell")
    public String houseforsell() {
        return "client/houseforsell";
    }

}
