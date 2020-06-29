package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.ContractDao;
import com.example.realproperty.entity.Contract;
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
public class ContractDaoImpl implements ContractDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addContract(Contract contract) {
        entityManager.persist(contract);
    }

    @Override
    public void updateContract(Contract contract) {
        entityManager.merge(contract);
    }

    @Override
    public Contract getContractByID(Integer id) {
        return entityManager.find(Contract.class, id);
    }

    @Override
    public List<Contract> getAllContract() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = builder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);

        TypedQuery<Contract> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}