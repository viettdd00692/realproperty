package com.example.realproperty.controller;

import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PropertyService propertyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/admin/list-client")
    private String list(Model model) {
        model.addAttribute("listClient", clientService.getAllClient());
        return "admin/client/listClient";
    }

    @GetMapping("/admin/add-client")
    private String add(Model model) {
        model.addAttribute("listProperty", propertyService.getAllProperty());
        model.addAttribute("addClientForm", new ClientDTO());
        return "admin/client/addClient";
    }

    @PostMapping("/admin/add-client")
    private String add(@ModelAttribute(name = "addClientForm") ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
        return "redirect:list-client";
    }

}