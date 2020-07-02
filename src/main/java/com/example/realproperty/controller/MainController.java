package com.example.realproperty.controller;

import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.ContractService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContractService contractService;

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
        model.addAttribute("totalPendingContract", contractService.getAllPendingContract().size());
        model.addAttribute("totalCommission", contractService.totalCommission());
        model.addAttribute("totalWaitingClient", clientService.getWaitingClient().size());
        model.addAttribute("totalAppraiseProperty", propertyService.getAllPropertyByStatus("Appraise").size());
        return "admin/dashboard";
    }

    @GetMapping("/property-for-rent")
    public String propertyforrent(Model model) {
        model.addAttribute("listHireProperty", propertyService.getHireProperty());
        return "client/propertyforrent";
    }

    @GetMapping("/property-for-sell")
    public String propertyforsell(Model model) {
        model.addAttribute("listSellProperty", propertyService.getSellProperty());
        return "client/propertyforsell";
    }

    @GetMapping("/contact")
    public String contact() {
        return "client/contact";
    }

}
