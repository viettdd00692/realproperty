package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.UserDao;
import com.example.realproperty.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public UserAccount getUserByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserAccount> criteriaQuery = builder.createQuery(UserAccount.class);
        Root<UserAccount> root = criteriaQuery.from(UserAccount.class);
        criteriaQuery.select(root);

        criteriaQuery.where(builder.equal(root.get("username"), username));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}