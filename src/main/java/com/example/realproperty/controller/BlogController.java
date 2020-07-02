package com.example.realproperty.controller;

import com.example.realproperty.model.BlogDTO;
import com.example.realproperty.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    private String UPLOAD_DIR = "D:\\SpringBoot\\realproperty\\src\\main\\resources\\static\\img\\admin\\";

    @GetMapping("/blog")
    public String index(Model model) {
        model.addAttribute("blogs", blogService.getAllBlog());
        return "/client/blog";
    }

    @GetMapping("/blogdetail/{id}")
    private String blogdetail(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("blog", blogService.getBlogByID(id));
        return "/client/blogdetail";
    }

    @GetMapping("/admin/list-blog")
    private String list(Model model) {
        model.addAttribute("listBlog", blogService.getAllBlog());
        return "admin/blog/listBlog";
    }

    @GetMapping("/admin/view-blog/{id}")
    private String view(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("getBlog", blogService.getBlogByID(id));
        return "admin/blog/viewBlog";
    }

    @GetMapping("/admin/add-blog")
    private String add(Model model) {
        model.addAttribute("addBlogForm", new BlogDTO());
        return "admin/blog/addBlog";
    }

    @PostMapping("/admin/add-blog")
    private String add(@ModelAttribute(name = "addBlogForm") BlogDTO blogDTO, @RequestParam("file") MultipartFile inputFile) throws IllegalStateException, IOException {
        HttpHeaders headers = new HttpHeaders();
        String originalFilename = inputFile.getOriginalFilename();
        File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
            inputFile.transferTo(destinationFile);
            blogDTO.setImage(originalFilename);
            blogService.addBlog(blogDTO);
        } else {
            blogDTO.setImage(originalFilename);
            blogService.addBlog(blogDTO);
        }

        headers.add("File Uploaded Successfully - ", inputFile.getName());
        return "redirect:list-blog";
    }

    @GetMapping("/blog-image/{id}")
    public ResponseEntity<byte[]> download(@PathVariable("id") Integer id) throws IOException {
        BlogDTO blogDTO = blogService.getBlogByID(id);
        File fileToUpload = new File(UPLOAD_DIR + "\\" + blogDTO.getImage());
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

    @GetMapping("/admin/update-blog/{id}")
    private String update(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("updateBlogForm", blogService.getBlogByID(id));
        return "admin/blog/updateBlog";
    }

    @PostMapping("/admin/update-blog")
    private void update(@ModelAttribute(name = "updateBlogForm") BlogDTO blogDTO, @RequestParam("file") MultipartFile inputFile, HttpServletResponse response) throws IllegalStateException, IOException {
        if (!inputFile.isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            String originalFilename = inputFile.getOriginalFilename();
            File destinationFile = new File(UPLOAD_DIR + File.separator + originalFilename);
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
                inputFile.transferTo(destinationFile);
                blogDTO.setImage(originalFilename);
                blogService.updateBlog(blogDTO);
            } else {
                blogDTO.setImage(originalFilename);
                blogService.updateBlog(blogDTO);
            }

            headers.add("File Uploaded Successfully - ", inputFile.getName());

        } else {
            blogDTO.setImage("");
            blogService.updateBlog(blogDTO);
        }

        response.sendRedirect("/admin/list-blog");
    }

}