package com.example.realproperty.model;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String fullname;

    private String avatar;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}