package com.example.realproperty.service;

import com.example.realproperty.model.BlogDTO;

import java.util.List;

public interface BlogService {
    void addBlog(BlogDTO blogDTO);

    void updateBlog(BlogDTO blogDTO);

    BlogDTO getBlogByID(Integer id);

    List<BlogDTO> getAllBlog();
}
