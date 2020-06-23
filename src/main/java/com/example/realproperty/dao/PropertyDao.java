package com.example.realproperty.dao;

import com.example.realproperty.entity.Property;

import java.util.List;

public interface PropertyDao {
    void addProperty(Property property);

    void updateProperty(Property property);

    Property getPropertyByID(int id);

    List<Property> getAllProperty();

    List<Property> getApartmentForSale();

    List<Property> getHouseForSale();

    List<Property> getApartmentForRent();

    List<Property> getHouseForRent();
}