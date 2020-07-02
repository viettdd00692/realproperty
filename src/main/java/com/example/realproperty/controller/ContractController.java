package com.example.realproperty.controller;

import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.model.ContractDTO;
import com.example.realproperty.model.OwnerDTO;
import com.example.realproperty.model.PropertyDTO;
import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.ContractService;
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
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private OwnerService ownerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/admin/list-contract")
    private String list(Model model) {
        model.addAttribute("listContract", contractService.getAllContract());
        return "admin/contract/listContract";
    }

    @GetMapping("/admin/view-contract/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getContract", contractService.getContractByID(id));
        return "admin/contract/viewContract";
    }

    @GetMapping("/admin/add-contract/{id}")
    private String add(Model model, @PathVariable(name = "id") Integer id) {
        ClientDTO clientDTO = clientService.getClientByID(id);
        PropertyDTO propertyDTO = propertyService.getPropertyByID(clientDTO.getPropertyId());
        OwnerDTO ownerDTO = ownerService.getOwnerByID(propertyDTO.getOwnerId());

        if (propertyDTO.getOption().equalsIgnoreCase("Mua")) {
            Integer comAttr = (propertyDTO.getPrice() * propertyDTO.getRate()) / 100;
            model.addAttribute("comAttr", comAttr);
        }

        if (propertyDTO.getOption().equalsIgnoreCase("Thuê") && propertyDTO.getRate() != null) {
            Integer comAttr = (propertyDTO.getPrice() * propertyDTO.getRate());
            model.addAttribute("comAttr", comAttr);
        }

        model.addAttribute("getClient", clientDTO);
        model.addAttribute("getProperty", propertyDTO);
        model.addAttribute("getOwner", ownerDTO);
        model.addAttribute("addContractForm", new ContractDTO());
        return "admin/contract/addContract";
    }

    @PostMapping("/admin/add-contract")
    private String add(@ModelAttribute(name = "addContractForm") ContractDTO contractDTO) {
        contractService.addContract(contractDTO);
        return "redirect:list-contract";
    }

    @GetMapping("/admin/update-contract/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        ClientDTO clientDTO = clientService.getClientByID(contractService.getContractByID(id).getClientId());
        PropertyDTO propertyDTO = propertyService.getPropertyByID(contractService.getContractByID(id).getPropertyId());
        OwnerDTO ownerDTO = ownerService.getOwnerByID(contractService.getContractByID(id).getOwnerId());
        model.addAttribute("getClient", clientDTO);
        model.addAttribute("getProperty", propertyDTO);
        model.addAttribute("getOwner", ownerDTO);
        model.addAttribute("updateContractForm", contractService.getContractByID(id));
        return "admin/contract/updateContract";
    }

    @PostMapping("/admin/update-contract")
    private void update(@ModelAttribute(name = "updateContractForm") ContractDTO contractDTO, HttpServletResponse response) throws IOException {
        contractService.updateContract(contractDTO);
        response.sendRedirect("/admin/list-contract");
    }

}