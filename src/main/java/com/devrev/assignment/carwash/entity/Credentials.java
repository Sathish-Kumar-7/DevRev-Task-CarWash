package com.devrev.assignment.carwash.entity;

import javax.persistence.*;

@Entity
@Table
public class Credentials {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    @Column(unique = false)
    private String customerName;
    @Column(unique = true)
    private String emailAddress;
    @Column(unique = true)
    private String phoneNumber;
    private int userAge;
    @Column(unique = true)
    private String userName;
    private String userPassword;

    public Credentials(String customerName, String emailAddress, String phoneNumber, int userAge, String userName, String userPassword) {
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.userAge = userAge;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Credentials(Long id, String customerName, String emailAddress, String phoneNumber, int userAge, String userName, String userPassword) {
        this.id = id;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.userAge = userAge;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Credentials(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Credentials() {
    }

    public Credentials(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userAge=" + userAge +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
