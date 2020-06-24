package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.PropertyDao;
import com.example.realproperty.entity.Property;
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
public class PropertyDaoImpl implements PropertyDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) {
        entityManager.persist(property);
    }

    @Override
    public void updateProperty(Property property) {
        entityManager.merge(property);
    }

    @Override
    public Property getPropertyByID(int id) {
        return entityManager.find(Property.class, id);
    }

    @Override
    public List<Property> getAllProperty() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);

        TypedQuery<Property> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }

    @Override
    public List<Property> getApartmentForSale() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Mua"), builder.equal(root.get("type"), "Căn hộ"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Property> getHouseForSale() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Mua"), builder.equal(root.get("type"), "Nhà riêng"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Property> getApartmentForRent() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Thuê"), builder.equal(root.get("type"), "Căn hộ"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Property> getHouseForRent() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Thuê"), builder.equal(root.get("type"), "Nhà riêng"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Property> getSellProperty() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Mua"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Property> getHireProperty() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> criteriaQuery = builder.createQuery(Property.class);
        Root<Property> root = criteriaQuery.from(Property.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("option"), "Thuê"));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}