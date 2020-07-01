package com.example.realproperty.controller;

import com.example.realproperty.model.OwnerDTO;
import com.example.realproperty.service.OwnerService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PropertyService propertyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/admin/list-owner")
    private String list(Model model) {
        model.addAttribute("listOwner", ownerService.getAllOwner());
        return "admin/owner/listOwner";
    }

    @GetMapping("/admin/view-owner/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getOwner", ownerService.getOwnerByID(id));
        model.addAttribute("getPropertyByOwner", propertyService.getAllPropertyByOwner(id));
        return "admin/owner/viewOwner";
    }

    @GetMapping("/admin/add-owner")
    private String add(Model model) {
        model.addAttribute("addOwnerForm", new OwnerDTO());
        return "admin/owner/addOwner";
    }

    @PostMapping("/admin/add-owner")
    private String add(@ModelAttribute(name = "addOwnerForm") OwnerDTO ownerDTO) {
        ownerService.addOwner(ownerDTO);
        return "redirect:list-owner";
    }

    @GetMapping("/admin/update-owner/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("updateOwnerForm", ownerService.getOwnerByID(id));
        return "admin/owner/updateOwner";
    }

    @PostMapping("/admin/update-owner")
    private void update(@ModelAttribute(name = "updateOwnerForm") OwnerDTO ownerDTO, HttpServletResponse response) throws IOException {
        ownerService.updateOwner(ownerDTO);
        response.sendRedirect("/admin/list-owner");
    }

}