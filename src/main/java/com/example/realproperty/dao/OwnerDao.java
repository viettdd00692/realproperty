package com.example.realproperty.dao;

import com.example.realproperty.entity.Owner;

import java.util.List;

public interface OwnerDao {
    void addOwner(Owner owner);

    void updateOwner(Owner owner);

    Owner getOwnerByID(Integer id);

    List<Owner> getAllOwner();
}
