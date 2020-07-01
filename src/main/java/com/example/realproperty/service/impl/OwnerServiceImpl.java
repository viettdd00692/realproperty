package com.example.realproperty.service.impl;

import com.example.realproperty.dao.OwnerDao;
import com.example.realproperty.entity.Owner;
import com.example.realproperty.model.OwnerDTO;
import com.example.realproperty.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerDao ownerDao;

    @Override
    public void addOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        owner.setFullname(ownerDTO.getFullname());
        owner.setEmail(ownerDTO.getEmail());
        owner.setPhone(ownerDTO.getPhone());
        owner.setAddress(ownerDTO.getAddress());
        owner.setStatus(ownerDTO.getStatus());

        ownerDao.addOwner(owner);
        ownerDTO.setId(owner.getId());
    }

    @Override
    public void updateOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerDao.getOwnerByID(ownerDTO.getId());
        if (owner != null) {
            owner.setFullname(ownerDTO.getFullname());
            owner.setEmail(ownerDTO.getEmail());
            owner.setPhone(ownerDTO.getPhone());
            owner.setAddress(ownerDTO.getAddress());
            owner.setStatus(ownerDTO.getStatus());

            ownerDao.updateOwner(owner);
        }
    }

    @Override
    public OwnerDTO getOwnerByID(Integer id) {
        Owner owner = ownerDao.getOwnerByID(id);
        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setId(owner.getId());
        ownerDTO.setFullname(owner.getFullname());
        ownerDTO.setEmail(owner.getEmail());
        ownerDTO.setPhone(owner.getPhone());
        ownerDTO.setAddress(owner.getAddress());
        ownerDTO.setStatus(owner.getStatus());

        return ownerDTO;
    }

    @Override
    public List<OwnerDTO> getAllOwner() {
        List<Owner> owners = ownerDao.getAllOwner();
        List<OwnerDTO> ownerDTOs = new ArrayList<OwnerDTO>();
        owners.forEach(owner -> {
            OwnerDTO ownerDTO = new OwnerDTO();

            ownerDTO.setId(owner.getId());
            ownerDTO.setFullname(owner.getFullname());
            ownerDTO.setEmail(owner.getEmail());
            ownerDTO.setPhone(owner.getPhone());
            ownerDTO.setAddress(owner.getAddress());
            ownerDTO.setStatus(owner.getStatus());

            ownerDTOs.add(ownerDTO);
        });
        return ownerDTOs;
    }

}