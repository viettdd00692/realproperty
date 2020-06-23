package com.example.realproperty.controller;

import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

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
    public String dashboard(Model model) {
        int count = employeeService.getAllEmployee().size();
        model.addAttribute("number", count);
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
