package com.example.realproperty.dao;

import com.example.realproperty.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee getEmployeeByID(Integer id);

    List<Employee> getAllEmployee();

    List<Employee> getAllEmployeeByClientID(Integer id);
}