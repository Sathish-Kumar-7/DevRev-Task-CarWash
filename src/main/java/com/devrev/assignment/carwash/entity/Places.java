package com.devrev.assignment.carwash.entity;

import javax.persistence.*;

@Entity
@Table
public class Places {
    @Id
    private Long pincode;
    @Column(unique = true)
    private String placeName;
    @Enumerated(EnumType.STRING)
    private Service service;

    public Places(Long pincode, String placeName, Service service) {
        this.pincode = pincode;
        this.placeName = placeName;
        this.service = service;
    }

    public Places(Long pincode) {
        this.pincode = pincode;
    }

    public Places() {
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
