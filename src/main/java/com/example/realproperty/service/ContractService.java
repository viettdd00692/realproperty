package com.example.realproperty.service;

import com.example.realproperty.model.ContractDTO;

import java.util.List;

public interface ContractService {
    void addContract(ContractDTO contractDTO);

    void updateContract(ContractDTO contractDTO);

    ContractDTO getContractByID(Integer id);

    List<ContractDTO> getAllContract();
}
