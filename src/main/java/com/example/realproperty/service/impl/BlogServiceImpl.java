package com.example.realproperty.service.impl;

import com.example.realproperty.dao.BlogDao;
import com.example.realproperty.entity.Blog;
import com.example.realproperty.model.BlogDTO;
import com.example.realproperty.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public void addBlog(BlogDTO blogDTO) {
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setImage(blogDTO.getImage());
        blog.setDescription(blogDTO.getDescription());

        blogDao.addBlog(blog);
        blogDTO.setId(blog.getId());
    }

    @Override
    public void updateBlog(BlogDTO blogDTO) {
        Blog blog = blogDao.getBlogByID(blogDTO.getId());
        if (blog != null) {
            blog.setTitle(blogDTO.getTitle());
            if (!blogDTO.getImage().isEmpty()) {
                blog.setImage(blogDTO.getImage());
            }
            blog.setDescription(blogDTO.getDescription());

            blogDao.updateBlog(blog);
        }
    }

    @Override
    public BlogDTO getBlogByID(Integer id) {
        Blog blog = blogDao.getBlogByID(id);
        BlogDTO blogDTO = new BlogDTO();

        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setImage(blog.getImage());
        blogDTO.setDescription(blog.getDescription());

        return blogDTO;
    }

    @Override
    public List<BlogDTO> getAllBlog() {
        List<Blog> blogs = blogDao.getAllBlog();
        List<BlogDTO> blogDTOs = new ArrayList<BlogDTO>();
        blogs.forEach(blog -> {
            BlogDTO blogDTO = new BlogDTO();

            blogDTO.setId(blog.getId());
            blogDTO.setTitle(blog.getTitle());
            blogDTO.setImage(blog.getImage());
            blogDTO.setDescription(blog.getDescription());

            blogDTOs.add(blogDTO);
        });
        return blogDTOs;
    }

}