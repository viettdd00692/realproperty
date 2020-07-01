package com.example.realproperty.service;

import com.example.realproperty.model.OwnerDTO;

import java.util.List;

public interface OwnerService {
    void addOwner(OwnerDTO ownerDTO);

    void updateOwner(OwnerDTO ownerDTO);

    OwnerDTO getOwnerByID(Integer id);

    List<OwnerDTO> getAllOwner();
}
