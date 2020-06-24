package com.example.realproperty.controller;

import com.example.realproperty.service.EmployeeService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listSellProperty", propertyService.getSellProperty());
        model.addAttribute("listHireProperty", propertyService.getHireProperty());
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

    @GetMapping("/property-for-rent")
    public String propertyforrent() {
        return "client/propertyforrent";
    }

    @GetMapping("/property-for-sell")
    public String propertyforsell() {
        return "client/propertyforsell";
    }

    @GetMapping("/contact")
    public String contact() {
        return "client/contact";
    }

}
