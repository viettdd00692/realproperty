package com.example.realproperty.dao;

import com.example.realproperty.entity.Client;

import java.util.List;

public interface ClientDao {
    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Client client);

    Client getClientByID(int id);

    List<Client> getAllClient();
}
