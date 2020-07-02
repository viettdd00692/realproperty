package com.example.realproperty.dao;

import com.example.realproperty.entity.Blog;

import java.util.List;

public interface BlogDao {
    void addBlog(Blog blog);

    void updateBlog(Blog blog);

    Blog getBlogByID(Integer id);

    List<Blog> getAllBlog();
}
