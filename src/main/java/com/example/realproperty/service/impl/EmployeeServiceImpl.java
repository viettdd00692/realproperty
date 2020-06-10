package com.example.realproperty.service.impl;

import com.example.realproperty.dao.EmployeeDao;
import com.example.realproperty.entity.Employee;
import com.example.realproperty.model.EmployeeDTO;
import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        employee.setAvatar(employeeDTO.getAvatar());

        employeeDao.addEmployee(employee);
        employeeDTO.setId(employee.getId());
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDao.getEmployeeByID(employeeDTO.getId());
        if (employee != null) {
            employee.setFullname(employeeDTO.getFullname());
            employee.setAvatar(employeeDTO.getAvatar());

            employeeDao.updateEmployee(employee);
        }
    }

    @Override
    public EmployeeDTO getEmployeeByID(int id) {
        Employee employee = employeeDao.getEmployeeByID(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());
        employeeDTO.setFullname(employee.getFullname());
        employeeDTO.setAvatar(employee.getAvatar());

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
            employeeDTO.setAvatar(employee.getAvatar());

            employeeDTOs.add(employeeDTO);
        });
        return employeeDTOs;
    }

}