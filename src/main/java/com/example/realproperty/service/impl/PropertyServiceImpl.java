package com.example.realproperty.service.impl;

import com.example.realproperty.dao.PropertyDao;
import com.example.realproperty.entity.Owner;
import com.example.realproperty.entity.Property;
import com.example.realproperty.model.PropertyDTO;
import com.example.realproperty.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyDao propertyDao;

    private PropertyDTO toDto(Property property) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(property.getId());
        propertyDTO.setName(property.getName());
        propertyDTO.setAddress(property.getAddress());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setRate(property.getRate());
        propertyDTO.setOption(property.getOption());
        propertyDTO.setType(property.getType());
        propertyDTO.setBedroom(property.getBedroom());
        propertyDTO.setBathroom(property.getBathroom());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setThumbnail(property.getThumbnail());
        propertyDTO.setStatus(property.getStatus());
        propertyDTO.setCreatedAt(property.getCreatedAt());
        propertyDTO.setUpdatedAt(property.getUpdatedAt());
        if (property.getOwner() != null) {
            propertyDTO.setOwnerId(property.getOwner().getId());
            propertyDTO.setOwnerName(property.getOwner().getFullname());
        }
        return propertyDTO;
    }

    @Override
    public void addProperty(PropertyDTO propertyDTO) {
        Property property = new Property();

        property.setName(propertyDTO.getName());
        property.setAddress(propertyDTO.getAddress());
        property.setDescription(propertyDTO.getDescription());
        property.setPrice(propertyDTO.getPrice());
        property.setRate(propertyDTO.getRate());
        property.setOption(propertyDTO.getOption());
        property.setType(propertyDTO.getType());
        property.setBedroom(propertyDTO.getBedroom());
        property.setBathroom(propertyDTO.getBathroom());
        property.setArea(propertyDTO.getArea());
        property.setThumbnail(propertyDTO.getThumbnail());
        property.setStatus(propertyDTO.getStatus());
        if (propertyDTO.getOwnerId() != null) {
            property.setOwner(new Owner(propertyDTO.getOwnerId()));
        }

        propertyDao.addProperty(property);
        propertyDTO.setId(property.getId());
    }

    @Override
    public void updateProperty(PropertyDTO propertyDTO) {
        Property property = propertyDao.getPropertyByID(propertyDTO.getId());
        if (property != null) {
            property.setName(propertyDTO.getName());
            property.setAddress(propertyDTO.getAddress());
            property.setDescription(propertyDTO.getDescription());
            property.setPrice(propertyDTO.getPrice());
            property.setRate(propertyDTO.getRate());
            property.setOption(propertyDTO.getOption());
            property.setType(propertyDTO.getType());
            property.setBedroom(propertyDTO.getBedroom());
            property.setBathroom(propertyDTO.getBathroom());
            property.setArea(propertyDTO.getArea());
            if (!propertyDTO.getThumbnail().isEmpty()) {
                property.setThumbnail(propertyDTO.getThumbnail());
            }
            property.setStatus(propertyDTO.getStatus());
            if (propertyDTO.getOwnerId() != null) {
                property.setOwner(new Owner(propertyDTO.getOwnerId()));
            } else {
                property.setOwner(null);
            }

            propertyDao.updateProperty(property);
        }
    }

    @Override
    public void updatePropertyStatus(PropertyDTO propertyDTO) {
        Property property = propertyDao.getPropertyByID(propertyDTO.getId());
        if (property != null) {
            property.setStatus(propertyDTO.getStatus());

            propertyDao.updateProperty(property);
        }
    }

    @Override
    public PropertyDTO getPropertyByID(Integer id) {
        Property property = propertyDao.getPropertyByID(id);
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(property.getId());
        propertyDTO.setName(property.getName());
        propertyDTO.setAddress(property.getAddress());
        propertyDTO.setDescription(property.getDescription());
        propertyDTO.setPrice(property.getPrice());
        propertyDTO.setRate(property.getRate());
        propertyDTO.setOption(property.getOption());
        propertyDTO.setType(property.getType());
        propertyDTO.setBedroom(property.getBedroom());
        propertyDTO.setBathroom(property.getBathroom());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setThumbnail(property.getThumbnail());
        propertyDTO.setStatus(property.getStatus());
        propertyDTO.setCreatedAt(property.getCreatedAt());
        propertyDTO.setUpdatedAt(property.getUpdatedAt());
        if (property.getOwner() != null) {
            propertyDTO.setOwnerId(property.getOwner().getId());
            propertyDTO.setOwnerName(property.getOwner().getFullname());
        }

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperty() {
        List<Property> properties = propertyDao.getAllProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            propertyDTOs.add(toDto(property));
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getAllAvailableProperty() {
        List<Property> properties = propertyDao.getAllProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase("Available") || property.getStatus().equalsIgnoreCase("Negotiation")) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getAllPropertyByStatus(String status) {
        List<Property> properties = propertyDao.getAllProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase(status)) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getAllPropertyByOwner(Integer ownerId) {
        List<Property> properties = propertyDao.getAllProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getOwner().getId() == ownerId) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getApartmentForSale() {
        List<Property> properties = propertyDao.getApartmentForSale();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            propertyDTOs.add(toDto(property));
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getApartmentForSaleByStatus(String status) {
        List<Property> properties = propertyDao.getApartmentForSale();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase(status)) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getHouseForSale() {
        List<Property> properties = propertyDao.getHouseForSale();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            propertyDTOs.add(toDto(property));
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getHouseForSaleByStatus(String status) {
        List<Property> properties = propertyDao.getHouseForSale();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase(status)) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getApartmentForRent() {
        List<Property> properties = propertyDao.getApartmentForRent();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            propertyDTOs.add(toDto(property));
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getApartmentForRentByStatus(String status) {
        List<Property> properties = propertyDao.getApartmentForRent();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase(status)) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getHouseForRent() {
        List<Property> properties = propertyDao.getHouseForRent();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            propertyDTOs.add(toDto(property));
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getHouseForRentByStatus(String status) {
        List<Property> properties = propertyDao.getHouseForRent();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase(status)) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getSellProperty() {
        List<Property> properties = propertyDao.getSellProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase("Available") || property.getStatus().equalsIgnoreCase("Negotiation")) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

    @Override
    public List<PropertyDTO> getHireProperty() {
        List<Property> properties = propertyDao.getHireProperty();
        List<PropertyDTO> propertyDTOs = new ArrayList<PropertyDTO>();
        properties.forEach(property -> {
            if (property.getStatus().equalsIgnoreCase("Available") || property.getStatus().equalsIgnoreCase("Negotiation")) {
                propertyDTOs.add(toDto(property));
            }
        });
        return propertyDTOs;
    }

}