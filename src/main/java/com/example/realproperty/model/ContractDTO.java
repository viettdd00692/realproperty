package com.example.realproperty.model;

import java.io.Serializable;
import java.util.Date;

public class ContractDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date startDate;
    private Integer duration;
    private Integer commission;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private Integer clientId;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private Integer propertyId;
    private String propertyName;
    private String propertyAddress;
    private String propertyDescription;
    private Integer propertyPrice;
    private String propertyOption;
    private String propertyType;
    private Integer propertyBedroom;
    private Integer propertyBathroom;
    private Integer propertyArea;

    public ContractDTO() {
        super();
    }

    public ContractDTO(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public Integer getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(Integer propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getPropertyOption() {
        return propertyOption;
    }

    public void setPropertyOption(String propertyOption) {
        this.propertyOption = propertyOption;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getPropertyBedroom() {
        return propertyBedroom;
    }

    public void setPropertyBedroom(Integer propertyBedroom) {
        this.propertyBedroom = propertyBedroom;
    }

    public Integer getPropertyBathroom() {
        return propertyBathroom;
    }

    public void setPropertyBathroom(Integer propertyBathroom) {
        this.propertyBathroom = propertyBathroom;
    }

    public Integer getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(Integer propertyArea) {
        this.propertyArea = propertyArea;
    }

}