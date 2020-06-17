package com.example.realproperty.controller;

import com.example.realproperty.model.EmployeeDTO;
import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @GetMapping("/admin/list-employee")
    private String list(Model model) {
        model.addAttribute("listEmployee", employeeService.getAllEmployee());
        return "admin/employee/listEmployee";
    }

    @GetMapping("/admin/update-employee/{id}")
    private String update(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("updateEmployeeForm", employeeService.getEmployeeByID(id));
        return "admin/employee/updateEmployee";
    }

    @PostMapping("/admin/update-employee")
    private void update(@ModelAttribute(name = "updateEmployeeForm") EmployeeDTO employeeDTO, HttpServletResponse response) throws IOException {
        employeeService.updateEmployee(employeeDTO);
        response.sendRedirect("/admin/list-employee");
    }

}