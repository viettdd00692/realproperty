package com.example.realproperty.service.impl;

import com.example.realproperty.dao.ClientDao;
import com.example.realproperty.entity.Client;
import com.example.realproperty.entity.Property;
import com.example.realproperty.model.ClientDTO;
import com.example.realproperty.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Override
    public void addClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setFullname(clientDTO.getFullname());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setAppointmentDate(clientDTO.getAppointmentDate());
        if (clientDTO.getPropertyId() != null) {
            client.setProperty(new Property(clientDTO.getPropertyId()));
        }
        client.setStatus(clientDTO.getStatus());

        clientDao.addClient(client);
        clientDTO.setId(client.getId());
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        Client client = clientDao.getClientByID(clientDTO.getId());
        if (client != null) {
            client.setFullname(clientDTO.getFullname());
            client.setEmail(clientDTO.getEmail());
            client.setPhone(clientDTO.getPhone());
            client.setAppointmentDate(clientDTO.getAppointmentDate());
            if (clientDTO.getPropertyId() != null) {
                client.setProperty(new Property(clientDTO.getPropertyId()));
            } else {
                client.setProperty(null);
            }
            client.setStatus(clientDTO.getStatus());

            clientDao.updateClient(client);
        }
    }

    @Override
    public ClientDTO getClientByID(Integer id) {
        Client client = clientDao.getClientByID(id);
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setFullname(client.getFullname());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setAppointmentDate(client.getAppointmentDate());
        if (client.getProperty() != null) {
            clientDTO.setPropertyId(client.getProperty().getId());
            clientDTO.setPropertyName(client.getProperty().getName());
        }
        clientDTO.setStatus(client.getStatus());

        return clientDTO;
    }

    @Override
    public List<ClientDTO> getAllClient() {
        List<Client> clients = clientDao.getAllClient();
        List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
        clients.forEach(client -> {
            ClientDTO clientDTO = new ClientDTO();

            clientDTO.setId(client.getId());
            clientDTO.setFullname(client.getFullname());
            clientDTO.setEmail(client.getEmail());
            clientDTO.setPhone(client.getPhone());
            clientDTO.setAppointmentDate(client.getAppointmentDate());
            if (client.getProperty() != null) {
                clientDTO.setPropertyId(client.getProperty().getId());
                clientDTO.setPropertyName(client.getProperty().getName());
            }
            clientDTO.setStatus(client.getStatus());

            clientDTOs.add(clientDTO);
        });
        return clientDTOs;
    }
}
