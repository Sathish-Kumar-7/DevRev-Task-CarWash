package com.devrev.assignment.carwash.entity;

import com.devrev.assignment.carwash.services.BookingService;
import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    private Long bookingId;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "credentials_customerid", referencedColumnName = "id")
    private Credentials customerId;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "places_pincode", referencedColumnName = "pincode")
    private Places pincode;

    @Column(unique = false)
    private String carName;

    @Column(unique = true)
    private String vehicleNum;

    @Enumerated(EnumType.STRING)
    private Service service;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;

    public Booking(Long bookingId, Credentials customerId, Places pincode, String carName, String vehicleNum, Service service, BookingStatus bookingStatus, LocalDate bookingDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pincode = pincode;
        this.carName = carName;
        this.vehicleNum = vehicleNum;
        this.service = service;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
    }

    public Booking(Credentials customerId, Places pincode, String carName, String vehicleNum, Service service, BookingStatus bookingStatus, LocalDate bookingDate) {
        this.customerId = customerId;
        this.pincode = pincode;
        this.carName = carName;
        this.vehicleNum = vehicleNum;
        this.service = service;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
    }

    public Booking(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Booking(Credentials customerId, Places pincode, String carName, String vehicleNum, Service service, LocalDate bookingDate) {
        this.customerId = customerId;
        this.pincode = pincode;
        this.carName = carName;
        this.vehicleNum = vehicleNum;
        this.service = service;
        this.bookingDate = bookingDate;
    }

    public Booking() {
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Credentials getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Credentials customerId) {
        this.customerId = customerId;
    }

    public Places getPincode() {
        return pincode;
    }

    public void setPincode(Places pincode) {
        this.pincode = pincode;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
