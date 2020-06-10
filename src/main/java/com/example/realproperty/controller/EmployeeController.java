package com.example.realproperty.controller;

import com.example.realproperty.model.EmployeeDTO;
import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/add-employee")
    private String add(Model model) {
        model.addAttribute("addEmployeeForm", new EmployeeDTO());
        return "admin/employee/addEmployee";
    }

    @PostMapping("/admin/add-employee")
    private String add(@ModelAttribute(name = "addEmployeeForm") EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
        return "redirect:list-employee";
    }

    @GetMapping("admin/list-employee")
    private String list(Model model) {
        model.addAttribute("listEmployee", employeeService.getAllEmployee());
        return "admin/employee/listEmployee";
    }

}