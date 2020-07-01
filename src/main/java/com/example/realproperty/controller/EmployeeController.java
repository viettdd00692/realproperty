package com.example.realproperty.controller;

import com.example.realproperty.model.EmployeeDTO;
import com.example.realproperty.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private String UPLOAD_DIR = "D:\\SpringBoot\\realproperty\\src\\main\\resources\\static\\img\\admin\\";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/admin/list-employee")
    private String list(Model model) {
        model.addAttribute("listEmployee", employeeService.getAllEmployee());
        return "admin/employee/listEmployee";
    }

    @GetMapping("/admin/view-employee/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getEmployee", employeeService.getEmployeeByID(id));
        return "admin/employee/viewEmployee";
    }

    @GetMapping("/admin/add-employee")
    private String add(Model model) {
        model.addAttribute("addEmployeeForm", new EmployeeDTO());
        return "admin/employee/addEmployee";
    }

    @PostMapping("/admin/add-employee")
    private String add(@ModelAttribute(name = "addEmployeeForm") EmployeeDTO employeeDTO, @RequestParam("file") MultipartFile inputFile) throws IllegalStateException, IOException {
        HttpHeaders headers = new HttpHeaders();
        String originalFilename = inputFile.getOriginalFilename();
        File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
            inputFile.transferTo(destinationFile);
            employeeDTO.setAvatar(originalFilename);
            employeeService.addEmployee(employeeDTO);
        } else {
            employeeDTO.setAvatar(originalFilename);
            employeeService.addEmployee(employeeDTO);
        }

        headers.add("File Uploaded Successfully - ", inputFile.getName());
        return "redirect:list-employee";
    }

    @GetMapping("/employee-avatar/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Integer id) throws IOException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeByID(id);
        File fileToUpload = new File(UPLOAD_DIR + "\\" + employeeDTO.getAvatar());
        InputStream inputImage = new FileInputStream(fileToUpload);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[512];
        int l = inputImage.read(buffer);
        while (l >= 0) {
            outputStream.write(buffer, 0, l);
            l = inputImage.read(buffer);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "image/jpeg");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        inputImage.close();
        return new ResponseEntity<byte[]>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }

    @GetMapping("/admin/update-employee/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("updateEmployeeForm", employeeService.getEmployeeByID(id));
        return "admin/employee/updateEmployee";
    }

    @PostMapping("/admin/update-employee")
    private void update(@ModelAttribute(name = "updateEmployeeForm") EmployeeDTO employeeDTO, @RequestParam("file") MultipartFile inputFile, HttpServletResponse response) throws IllegalStateException, IOException {
        if (!inputFile.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            String originalFilename = inputFile.getOriginalFilename();
            File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
                inputFile.transferTo(destinationFile);
                employeeDTO.setAvatar(originalFilename);
                employeeService.updateEmployee(employeeDTO);
            } else {
                employeeDTO.setAvatar(originalFilename);
                employeeService.updateEmployee(employeeDTO);
            }

            headers.add("File Uploaded Successfully - ", inputFile.getName());

        } else {
            employeeDTO.setAvatar("");
            employeeService.updateEmployee(employeeDTO);
        }

        response.sendRedirect("/admin/list-employee");
    }

}