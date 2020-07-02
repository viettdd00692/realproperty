package com.example.realproperty.service.impl;

import com.example.realproperty.dao.ContractDao;
import com.example.realproperty.entity.Client;
import com.example.realproperty.entity.Contract;
import com.example.realproperty.entity.Owner;
import com.example.realproperty.entity.Property;
import com.example.realproperty.model.ContractDTO;
import com.example.realproperty.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractDao contractDao;

    @Override
    public void addContract(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setStartDate(contractDTO.getStartDate());
        contract.setDuration(contractDTO.getDuration());
        contract.setCommission(contractDTO.getCommission());
        contract.setStatus(contractDTO.getStatus());
        if (contractDTO.getClientId() != null) {
            contract.setClient(new Client(contractDTO.getClientId()));
        }
        if (contractDTO.getPropertyId() != null) {
            contract.setProperty(new Property(contractDTO.getPropertyId()));
        }
        if (contractDTO.getOwnerId() != null) {
            contract.setOwner(new Owner(contractDTO.getOwnerId()));
        }

        contractDao.addContract(contract);
        contractDTO.setId(contract.getId());
    }

    @Override
    public void updateContract(ContractDTO contractDTO) {
        Contract contract = contractDao.getContractByID(contractDTO.getId());
        if (contract != null) {
            contract.setStartDate(contractDTO.getStartDate());
            contract.setDuration(contractDTO.getDuration());
            contract.setCommission(contractDTO.getCommission());
            contract.setStatus(contractDTO.getStatus());
            if (contractDTO.getClientId() != null) {
                contract.setClient(new Client(contractDTO.getClientId()));
            } else {
                contract.setClient(null);
            }
            if (contractDTO.getPropertyId() != null) {
                contract.setProperty(new Property(contractDTO.getPropertyId()));
            } else {
                contract.setProperty(null);
            }
            if (contractDTO.getOwnerId() != null) {
                contract.setOwner(new Owner(contractDTO.getOwnerId()));
            } else {
                contract.setOwner(null);
            }

            contractDao.updateContract(contract);
        }
    }

    @Override
    public ContractDTO getContractByID(Integer id) {
        Contract contract = contractDao.getContractByID(id);
        ContractDTO contractDTO = new ContractDTO();

        contractDTO.setId(contract.getId());
        contractDTO.setStartDate(contract.getStartDate());
        contractDTO.setDuration(contract.getDuration());
        contractDTO.setCommission(contract.getCommission());
        contractDTO.setStatus(contract.getStatus());
        contractDTO.setCreatedAt(contract.getCreatedAt());
        contractDTO.setUpdatedAt(contract.getUpdatedAt());
        if (contract.getClient() != null) {
            contractDTO.setClientId(contract.getClient().getId());
            contractDTO.setClientName(contract.getClient().getFullname());
            contractDTO.setClientEmail(contract.getClient().getEmail());
            contractDTO.setClientPhone(contract.getClient().getPhone());
        }
        if (contract.getProperty() != null) {
            contractDTO.setPropertyId(contract.getProperty().getId());
            contractDTO.setPropertyName(contract.getProperty().getName());
            contractDTO.setPropertyAddress(contract.getProperty().getAddress());
            contractDTO.setPropertyDescription(contract.getProperty().getDescription());
            contractDTO.setPropertyPrice(contract.getProperty().getPrice());
            contractDTO.setPropertyRate(contract.getProperty().getRate());
            contractDTO.setPropertyOption(contract.getProperty().getOption());
            contractDTO.setPropertyType(contract.getProperty().getType());
            contractDTO.setPropertyBedroom(contract.getProperty().getBedroom());
            contractDTO.setPropertyBathroom(contract.getProperty().getBathroom());
            contractDTO.setPropertyArea(contract.getProperty().getArea());
        }
        if (contract.getOwner() != null) {
            contractDTO.setOwnerId(contract.getOwner().getId());
            contractDTO.setOwnerName(contract.getOwner().getFullname());
            contractDTO.setOwnerEmail(contract.getOwner().getEmail());
            contractDTO.setOwnerPhone(contract.getOwner().getPhone());
            contractDTO.setOwnerAddress(contract.getOwner().getAddress());
        }

        return contractDTO;
    }

    @Override
    public List<ContractDTO> getAllContract() {
        List<Contract> contracts = contractDao.getAllContract();
        List<ContractDTO> contractDTOs = new ArrayList<ContractDTO>();
        contracts.forEach(contract -> {
            ContractDTO contractDTO = new ContractDTO();

            contractDTO.setId(contract.getId());
            contractDTO.setStartDate(contract.getStartDate());
            contractDTO.setDuration(contract.getDuration());
            contractDTO.setCommission(contract.getCommission());
            contractDTO.setStatus(contract.getStatus());
            contractDTO.setCreatedAt(contract.getCreatedAt());
            contractDTO.setUpdatedAt(contract.getUpdatedAt());
            if (contract.getClient() != null) {
                contractDTO.setClientId(contract.getClient().getId());
                contractDTO.setClientName(contract.getClient().getFullname());
                contractDTO.setClientEmail(contract.getClient().getEmail());
                contractDTO.setClientPhone(contract.getClient().getPhone());
            }
            if (contract.getProperty() != null) {
                contractDTO.setPropertyId(contract.getProperty().getId());
                contractDTO.setPropertyName(contract.getProperty().getName());
                contractDTO.setPropertyAddress(contract.getProperty().getAddress());
                contractDTO.setPropertyDescription(contract.getProperty().getDescription());
                contractDTO.setPropertyPrice(contract.getProperty().getPrice());
                contractDTO.setPropertyRate(contract.getProperty().getRate());
                contractDTO.setPropertyOption(contract.getProperty().getOption());
                contractDTO.setPropertyType(contract.getProperty().getType());
                contractDTO.setPropertyBedroom(contract.getProperty().getBedroom());
                contractDTO.setPropertyBathroom(contract.getProperty().getBathroom());
                contractDTO.setPropertyArea(contract.getProperty().getArea());
            }
            if (contract.getOwner() != null) {
                contractDTO.setOwnerId(contract.getOwner().getId());
                contractDTO.setOwnerName(contract.getOwner().getFullname());
                contractDTO.setOwnerEmail(contract.getOwner().getEmail());
                contractDTO.setOwnerPhone(contract.getOwner().getPhone());
                contractDTO.setOwnerAddress(contract.getOwner().getAddress());
            }

            contractDTOs.add(contractDTO);
        });
        return contractDTOs;
    }

    @Override
    public List<ContractDTO> getAllPendingContract() {
        List<Contract> contracts = contractDao.getAllContract();
        List<ContractDTO> contractDTOs = new ArrayList<ContractDTO>();
        contracts.forEach(contract -> {
            if (contract.getStatus().equalsIgnoreCase("Pending")) {
                ContractDTO contractDTO = new ContractDTO();
                contractDTO.setId(contract.getId());
                contractDTO.setStatus(contract.getStatus());
                contractDTOs.add(contractDTO);
            }
        });
        return contractDTOs;
    }

    @Override
    public Integer totalCommission() {
        List<Contract> contracts = contractDao.getAllContract();
        Integer commission = 0;
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getStatus().equalsIgnoreCase("Complete")) {
                commission += contracts.get(i).getCommission();
            }
        }
        return commission;
    }

}