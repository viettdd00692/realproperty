package com.example.realproperty.controller;

import com.example.realproperty.entity.Blog;
import com.example.realproperty.service.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/blog")
    public String index(Model model){
        List<Blog> blogs = (List<Blog>) blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        return "/client/blog";
    }

    @RequestMapping(value = "/blogdetail", method = RequestMethod.GET)
    public String blogdetail(@RequestParam("id") Long blogId , Model model){
        Optional<Blog> blogdetail = blogRepository.findById(blogId);
        blogdetail.ifPresent(blog ->model.addAttribute("blog",blog));
        return "/client/blogdetail";
    }
}
