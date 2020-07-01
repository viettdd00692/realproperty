package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.OwnerDao;
import com.example.realproperty.entity.Owner;
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
public class OwnerDaoImpl implements OwnerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addOwner(Owner owner) {
        entityManager.persist(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        entityManager.merge(owner);
    }

    @Override
    public Owner getOwnerByID(Integer id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public List<Owner> getAllOwner() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> criteriaQuery = builder.createQuery(Owner.class);
        Root<Owner> root = criteriaQuery.from(Owner.class);

        TypedQuery<Owner> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
