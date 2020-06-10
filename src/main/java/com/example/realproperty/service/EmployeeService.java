package com.example.realproperty.service;

import com.example.realproperty.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeByID(int id);

    List<EmployeeDTO> getAllEmployee();
}
