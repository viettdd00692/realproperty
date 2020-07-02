package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.BlogDao;
import com.example.realproperty.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addBlog(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public Blog getBlogByID(Integer id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public List<Blog> getAllBlog() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Blog> criteriaQuery = builder.createQuery(Blog.class);
        Root<Blog> root = criteriaQuery.from(Blog.class);

        TypedQuery<Blog> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }

}