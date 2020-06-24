package com.example.realproperty.service;

import com.example.realproperty.model.ClientDTO;

import java.util.List;

public interface ClientService {
    void addClient(ClientDTO clientDTO);

    void updateClient(ClientDTO clientDTO);

    void deleteClient(int id);

    ClientDTO getClientByID(int id);

    List<ClientDTO> getAllClient();
}
