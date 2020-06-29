package com.example.realproperty.controller;

import com.example.realproperty.model.PropertyDTO;
import com.example.realproperty.service.PropertyService;
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
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    private String UPLOAD_DIR = "D:\\SpringBoot\\realproperty\\src\\main\\resources\\static\\img\\admin\\";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/admin/list-property")
    private String list(Model model) {
        model.addAttribute("listProperty", propertyService.getAllProperty());
        return "admin/property/listProperty";
    }

    @GetMapping("/admin/list-property/{status}")
    private String listByStatus(Model model, @PathVariable(name = "status") String status) {
        model.addAttribute("listProperty", propertyService.getAllPropertyByStatus(status));
        return "admin/property/listProperty";
    }

    @GetMapping("/admin/apartments-for-sale")
    private String apartmentSale(Model model) {
        model.addAttribute("listApartmentSale", propertyService.getApartmentForSale());
        return "admin/property/listApartmentForSale";
    }

    @GetMapping("/admin/apartments-for-sale/{status}")
    private String apartmentSaleByStatus(Model model, @PathVariable(name = "status") String status) {
        model.addAttribute("listApartmentSale", propertyService.getApartmentForSaleByStatus(status));
        return "admin/property/listApartmentForSale";
    }

    @GetMapping("/admin/houses-for-sale")
    private String houseSale(Model model) {
        model.addAttribute("listHouseSale", propertyService.getHouseForSale());
        return "admin/property/listHouseForSale";
    }

    @GetMapping("/admin/houses-for-sale/{status}")
    private String houseSaleByStatus(Model model, @PathVariable(name = "status") String status) {
        model.addAttribute("listHouseSale", propertyService.getHouseForSaleByStatus(status));
        return "admin/property/listHouseForSale";
    }

    @GetMapping("/admin/apartments-for-rent")
    private String apartmentRent(Model model) {
        model.addAttribute("listApartmentRent", propertyService.getApartmentForRent());
        return "admin/property/listApartmentForRent";
    }

    @GetMapping("/admin/apartments-for-rent/{status}")
    private String apartmentRentByStatus(Model model, @PathVariable(name = "status") String status) {
        model.addAttribute("listApartmentRent", propertyService.getApartmentForRentByStatus(status));
        return "admin/property/listApartmentForRent";
    }

    @GetMapping("/admin/houses-for-rent")
    private String houseRent(Model model) {
        model.addAttribute("listHouseRent", propertyService.getHouseForRent());
        return "admin/property/listHouseForRent";
    }

    @GetMapping("/admin/houses-for-rent/{status}")
    private String houseRentByStatus(Model model, @PathVariable(name = "status") String status) {
        model.addAttribute("listHouseRent", propertyService.getHouseForRentByStatus(status));
        return "admin/property/listHouseForRent";
    }

    @GetMapping("/admin/view-property/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getProperty", propertyService.getPropertyByID(id));
        return "admin/property/viewProperty";
    }

    @GetMapping("/admin/add-property")
    private String add(Model model) {
        model.addAttribute("addPropertyForm", new PropertyDTO());
        return "admin/property/addProperty";
    }

    @PostMapping("/admin/add-property")
    private String add(@ModelAttribute(name = "addPropertyForm") PropertyDTO propertyDTO, @RequestParam("file") MultipartFile inputFile) throws IllegalStateException, IOException {
        HttpHeaders headers = new HttpHeaders();
        String originalFilename = inputFile.getOriginalFilename();
        File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
            inputFile.transferTo(destinationFile);
            propertyDTO.setThumbnail(originalFilename);
            propertyService.addProperty(propertyDTO);
        } else {
            propertyDTO.setThumbnail(originalFilename);
            propertyService.addProperty(propertyDTO);
        }

        headers.add("File Uploaded Successfully - ", inputFile.getName());
        return "redirect:list-property";
    }

    @GetMapping("/property-thumbnail/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Integer id) throws IOException {
        PropertyDTO propertyDTO = propertyService.getPropertyByID(id);
        File fileToUpload = new File(UPLOAD_DIR + "\\" + propertyDTO.getThumbnail());
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

    @GetMapping("/admin/update-property/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("updatePropertyForm", propertyService.getPropertyByID(id));
        return "admin/property/updateProperty";
    }

    @PostMapping("/admin/update-property")
    private void update(@ModelAttribute(name = "updatePropertyForm") PropertyDTO propertyDTO, @RequestParam("file") MultipartFile inputFile, HttpServletResponse response) throws IllegalStateException, IOException {
        if (!inputFile.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            String originalFilename = inputFile.getOriginalFilename();
            File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
                inputFile.transferTo(destinationFile);
                propertyDTO.setThumbnail(originalFilename);
                propertyService.updateProperty(propertyDTO);
            } else {
                propertyDTO.setThumbnail(originalFilename);
                propertyService.updateProperty(propertyDTO);
            }

            headers.add("File Uploaded Successfully - ", inputFile.getName());

        } else {
            propertyDTO.setThumbnail("");
            propertyService.updateProperty(propertyDTO);
        }

        response.sendRedirect("/admin/list-property");
    }

}