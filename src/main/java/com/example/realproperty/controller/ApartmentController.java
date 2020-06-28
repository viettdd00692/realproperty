package com.example.realproperty.controller;

import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ApartmentController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PropertyService propertyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/apartment-detail/{id}")
    private String apartmentDetail(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("getProperty", propertyService.getPropertyByID(id));
        model.addAttribute("listProperty", propertyService.getAllProperty());
        model.addAttribute("addClientForm", new ClientDTO());
        model.addAttribute("listSellProperty", propertyService.getSellProperty());
        model.addAttribute("listHireProperty", propertyService.getHireProperty());
        return "client/apartmentdetail";
    }



    @PostMapping("/apartment-detail/{id}")
    private String add(@ModelAttribute(name = "addClientForm") ClientDTO clientDTO, @PathVariable(name = "id") int id , RedirectAttributes redirect) {

        clientService.addClient(clientDTO);
        redirect.addFlashAttribute("successMessage", "Send contact successfully!");
        return "redirect:{id}";
    }
}
