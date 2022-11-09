package com.devrev.assignment.carwash.repository;

import com.devrev.assignment.carwash.entity.Booking;
import com.devrev.assignment.carwash.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> findAllBookingsByBookingDate(LocalDate date);

    List<Booking> findBookingByCustomerId(Credentials id);

    List<Booking> findBookingByBookingDate(LocalDate date);
    List<Booking> findBookingByPincode_PlaceName(String place);

}
