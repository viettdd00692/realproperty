package com.example.realproperty.service;

import com.example.realproperty.model.PropertyDTO;

import java.util.List;

public interface PropertyService {
    void addProperty(PropertyDTO propertyDTO);

    void updateProperty(PropertyDTO propertyDTO);

    void updatePropertyStatus(PropertyDTO propertyDTO);

    PropertyDTO getPropertyByID(Integer id);

    List<PropertyDTO> getAllProperty();

    List<PropertyDTO> getAllPropertyByStatus(String status);

    List<PropertyDTO> getAllPropertyByOwner(Integer ownerId);

    List<PropertyDTO> getApartmentForSale();

    List<PropertyDTO> getApartmentForSaleByStatus(String status);

    List<PropertyDTO> getHouseForSale();

    List<PropertyDTO> getHouseForSaleByStatus(String status);

    List<PropertyDTO> getApartmentForRent();

    List<PropertyDTO> getApartmentForRentByStatus(String status);

    List<PropertyDTO> getHouseForRent();

    List<PropertyDTO> getHouseForRentByStatus(String status);

    List<PropertyDTO> getSellProperty();

    List<PropertyDTO> getHireProperty();
}
