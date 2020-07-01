package com.example.realproperty.controller;

import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.model.PropertyDTO;
import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.EmployeeService;
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
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private EmployeeService employeeService;

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

    @GetMapping("/admin/view-client/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getClient", clientService.getClientByID(id));
        return "admin/client/viewClient";
    }

    @GetMapping("/admin/add-client")
    private String add(Model model) {
        model.addAttribute("listProperty", propertyService.getAllAvailableProperty());
        model.addAttribute("addClientForm", new ClientDTO());
        return "admin/client/addClient";
    }

    @PostMapping("/admin/add-client")
    private String add(@ModelAttribute(name = "addClientForm") ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
        if (clientDTO.getPropertyId() != null) {
            PropertyDTO propertyDTO = propertyService.getPropertyByID(clientDTO.getPropertyId());
            propertyDTO.setStatus("Negotiation");
            propertyService.updatePropertyStatus(propertyDTO);
        }
        return "redirect:list-client";
    }

    @GetMapping("/admin/update-client/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("listProperty", propertyService.getAllAvailableProperty());
        model.addAttribute("listEmployee", employeeService.getAllStandbyEmployee());
        model.addAttribute("updateClientForm", clientService.getClientByID(id));
        return "admin/client/updateClient";
    }

    @PostMapping("/admin/update-client")
    private void update(@ModelAttribute(name = "updateClientForm") ClientDTO clientDTO, HttpServletResponse response) throws IOException {
        clientService.updateClient(clientDTO);
        if (clientDTO.getPropertyId() != null) {
            PropertyDTO propertyDTO = propertyService.getPropertyByID(clientDTO.getPropertyId());
            propertyDTO.setStatus("Negotiation");
            propertyService.updatePropertyStatus(propertyDTO);
        }
        response.sendRedirect("/admin/list-client");
    }

}