package com.example.realproperty.model;

import java.io.Serializable;

public class BlogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String image;

    private String description;

    public BlogDTO() {
    }

    public BlogDTO(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}