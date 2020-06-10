package com.example.realproperty.dao;

import com.example.realproperty.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee getEmployeeByID(int id);

    List<Employee> getAllEmployee();
}