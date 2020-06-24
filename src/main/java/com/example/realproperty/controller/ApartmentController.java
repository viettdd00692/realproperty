package com.example.realproperty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApartmentController {

    @GetMapping("/apartment-detail")
    public String apartmentdetail() {
        return "client/apartmentdetail";
    }
}
