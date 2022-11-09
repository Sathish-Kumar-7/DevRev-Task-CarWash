package com.devrev.assignment.carwash.services;

import com.devrev.assignment.carwash.entity.Booking;
import com.devrev.assignment.carwash.entity.BookingMaxCount;
import com.devrev.assignment.carwash.entity.Credentials;
import com.devrev.assignment.carwash.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    public final BookingRepo bookingRepo;

    BookingService(BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
    }


    public boolean addNewBooking(Booking booking) {
        if(bookingRepo
                .findAllBookingsByBookingDate(
                        LocalDate.parse(
                                booking.getBookingDate().toString(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        )).size() <= BookingMaxCount.maxBookingCount){
            booking.setBookingDate(LocalDate.parse(
                    booking.getBookingDate().toString(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            ));
            bookingRepo.save(booking);
            return true;
        }else
            return false;
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public boolean updateBooking(Booking booking) {
        if(bookingRepo.findById(booking.getBookingId()).isPresent()){
            bookingRepo.save(booking);
            return true;
        }else
            return false;
    }
    public List<Booking> getAllBookingsById(Long id) {
        return bookingRepo.findBookingByCustomerId(new Credentials(id));
    }

    public Integer getBookingAvailability(String date) {
        return BookingMaxCount.maxBookingCount - bookingRepo.findBookingByBookingDate(LocalDate.parse(
                date, DateTimeFormatter.ofPattern("yyyy-MM-dd")
        )).size();
    }

    public List<Booking> getBookingsByPlace(String place) {
        return bookingRepo.findBookingByPincode_PlaceName(place);
    }

    public List<Booking> getBookingsByDate(String date) {
        return bookingRepo.findBookingByBookingDate(
                LocalDate.parse(
                        date, DateTimeFormatter.ofPattern("yyyy-MM-dd")
                ));
    }
}
