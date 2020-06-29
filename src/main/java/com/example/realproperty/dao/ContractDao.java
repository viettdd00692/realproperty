package com.example.realproperty.dao;

import com.example.realproperty.entity.Contract;

import java.util.List;

public interface ContractDao {
    void addContract(Contract contract);

    void updateContract(Contract contract);

    Contract getContractByID(Integer id);

    List<Contract> getAllContract();
}
