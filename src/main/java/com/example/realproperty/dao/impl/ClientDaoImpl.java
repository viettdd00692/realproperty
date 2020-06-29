package com.example.realproperty.dao.impl;

import com.example.realproperty.dao.ClientDao;
import com.example.realproperty.entity.Client;
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
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addClient(Client client) {
        entityManager.persist(client);
    }

    @Override
    public void updateClient(Client client) {
        entityManager.merge(client);
    }

    @Override
    public Client getClientByID(Integer id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> getAllClient() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = builder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);

        TypedQuery<Client> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
        return typedQuery.getResultList();
    }
}
