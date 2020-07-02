package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.ImageDao;
import com.example.realproperty.entity.Image;
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
public class ImageDaoImpl implements ImageDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addImage(Image image) {
        entityManager.persist(image);
    }

    @Override
    public Image getImageByID(Integer id) {
        return entityManager.find(Image.class, id);
    }

    @Override
    public List<Image> getAllImage() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Image> criteriaQuery = builder.createQuery(Image.class);
        Root<Image> root = criteriaQuery.from(Image.class);

        TypedQuery<Image> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
