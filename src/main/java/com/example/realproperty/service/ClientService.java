package com.example.realproperty.service;

import com.example.realproperty.model.ClientDTO;

import java.util.List;

public interface ClientService {
    void addClient(ClientDTO clientDTO);

    void updateClient(ClientDTO clientDTO);

    ClientDTO getClientByID(Integer id);

    List<ClientDTO> getAllClient();

    List<ClientDTO> getAllClientByEmployeeID(Integer id);

    List<ClientDTO> getWaitingClient();
}
