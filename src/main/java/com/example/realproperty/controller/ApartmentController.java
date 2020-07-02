package com.example.realproperty.controller;

import com.example.realproperty.config.MyConstants;
import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.service.ClientService;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ApartmentController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PropertyService propertyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/apartment-detail/{id}")
    private String apartmentDetail(Model model, @PathVariable(name = "id") int id) {
        model.addAttribute("getProperty", propertyService.getPropertyByID(id));
        model.addAttribute("listProperty", propertyService.getAllProperty());
        model.addAttribute("addClientForm", new ClientDTO());
        model.addAttribute("listSellProperty", propertyService.getSellProperty());
        model.addAttribute("listHireProperty", propertyService.getHireProperty());
        return "client/apartmentdetail";
    }



    @PostMapping("/apartment-detail/{id}")
    private String add(@ModelAttribute(name = "addClientForm") ClientDTO clientDTO, @PathVariable(name = "id") int id , RedirectAttributes redirect) throws MessagingException {
        clientDTO.setStatus("Waiting");
        clientService.addClient(clientDTO);
        redirect.addFlashAttribute("successMessage", "Send contact successfully!");

//        MimeMessage message = emailSender.createMimeMessage();
//
//        boolean multipart = true;
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
//
//        String htmlMsg = "<h3>Your contact is send successfully</h3>"
//                +"<img src='https://www.doorman24.com/wp-content/uploads/2016/07/thankyou.jpg'>";
//
//        message.setContent(htmlMsg, "text/html");
//
//        helper.setTo(clientDTO.getEmail());
//
//        helper.setSubject("Real Property - Send contact successfully!");
//
//
//        this.emailSender.send(message);
        return "redirect:{id}";
    }

}