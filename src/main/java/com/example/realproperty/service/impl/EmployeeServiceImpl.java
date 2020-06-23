package com.example.realproperty.service.impl;

import com.example.realproperty.dao.EmployeeDao;
import com.example.realproperty.entity.Employee;
import com.example.realproperty.model.EmployeeDTO;
import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFullname(employeeDTO.getFullname());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setBirthdate(employeeDTO.getBirthdate());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());
        employee.setAvatar(employeeDTO.getAvatar());
        employee.setJoinDate(employeeDTO.getJoinDate());
        employee.setResignDate(employeeDTO.getResignDate());
        employee.setStatus(employeeDTO.getStatus());

        employeeDao.addEmployee(employee);
        employeeDTO.setId(employee.getId());
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDao.getEmployeeByID(employeeDTO.getId());
        if (employee != null) {
            employee.setFullname(employeeDTO.getFullname());
            employee.setAddress(employeeDTO.getAddress());
            employee.setPhone(employeeDTO.getPhone());
            employee.setEmail(employeeDTO.getEmail());
            employee.setBirthdate(employeeDTO.getBirthdate());
            employee.setPosition(employeeDTO.getPosition());
            employee.setSalary(employeeDTO.getSalary());
            if (!employeeDTO.getAvatar().isEmpty()) {
                employee.setAvatar(employeeDTO.getAvatar());
            }
            employee.setJoinDate(employeeDTO.getJoinDate());
            employee.setResignDate(employeeDTO.getResignDate());
            employee.setStatus(employeeDTO.getStatus());

            employeeDao.updateEmployee(employee);
        }
    }

    @Override
    public EmployeeDTO getEmployeeByID(int id) {
        Employee employee = employeeDao.getEmployeeByID(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setFullname(employee.getFullname());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setBirthdate(employee.getBirthdate());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setAvatar(employee.getAvatar());
        employeeDTO.setJoinDate(employee.getJoinDate());
        employeeDTO.setResignDate(employee.getResignDate());
        employeeDTO.setStatus(employee.getStatus());

        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeDao.getAllEmployee();
        List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();

            employeeDTO.setId(employee.getId());
            employeeDTO.setFullname(employee.getFullname());
            employeeDTO.setAddress(employee.getAddress());
            employeeDTO.setPhone(employee.getPhone());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setBirthdate(employee.getBirthdate());
            employeeDTO.setPosition(employee.getPosition());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setAvatar(employee.getAvatar());
            employeeDTO.setJoinDate(employee.getJoinDate());
            employeeDTO.setResignDate(employee.getResignDate());
            employeeDTO.setStatus(employee.getStatus());

            employeeDTOs.add(employeeDTO);
        });
        return employeeDTOs;
    }

}