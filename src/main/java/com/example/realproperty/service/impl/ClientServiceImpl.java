package com.example.realproperty.service.impl;

import com.example.realproperty.dao.ClientDao;
import com.example.realproperty.entity.Client;
import com.example.realproperty.entity.Employee;
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
        client.setStatus(clientDTO.getStatus());
        if (clientDTO.getPropertyId() != null) {
            client.setProperty(new Property(clientDTO.getPropertyId()));
        }
        if (clientDTO.getEmployeeId() != null) {
            client.setEmployee(new Employee(clientDTO.getEmployeeId()));
        }

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
            client.setStatus(clientDTO.getStatus());
            if (clientDTO.getPropertyId() != null) {
                client.setProperty(new Property(clientDTO.getPropertyId()));
            } else {
                client.setProperty(null);
            }
            if (clientDTO.getEmployeeId() != null) {
                client.setEmployee(new Employee(clientDTO.getEmployeeId()));
            } else {
                client.setEmployee(null);
            }

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
        clientDTO.setStatus(client.getStatus());
        clientDTO.setCreatedAt(client.getCreatedAt());
        clientDTO.setUpdatedAt(client.getUpdatedAt());
        if (client.getProperty() != null) {
            clientDTO.setPropertyId(client.getProperty().getId());
            clientDTO.setPropertyName(client.getProperty().getName());
        }
        if (client.getEmployee() != null) {
            clientDTO.setEmployeeId(client.getEmployee().getId());
            clientDTO.setEmployeeName(client.getEmployee().getFullname());
        }

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
            clientDTO.setStatus(client.getStatus());
            clientDTO.setCreatedAt(client.getCreatedAt());
            clientDTO.setUpdatedAt(client.getUpdatedAt());
            if (client.getProperty() != null) {
                clientDTO.setPropertyId(client.getProperty().getId());
                clientDTO.setPropertyName(client.getProperty().getName());
            }
            if (client.getEmployee() != null) {
                clientDTO.setEmployeeId(client.getEmployee().getId());
                clientDTO.setEmployeeName(client.getEmployee().getFullname());
            }

            clientDTOs.add(clientDTO);
        });

        return clientDTOs;
    }

}