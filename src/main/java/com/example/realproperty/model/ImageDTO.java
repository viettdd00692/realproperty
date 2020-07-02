package com.example.realproperty.model;

import java.io.Serializable;

public class ImageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String image;

    private Integer propertyId;

    public ImageDTO() {
    }

    public ImageDTO(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

}