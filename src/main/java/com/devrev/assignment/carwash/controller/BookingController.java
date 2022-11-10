package com.devrev.assignment.carwash.controller;

import com.devrev.assignment.carwash.entity.Booking;
import com.devrev.assignment.carwash.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "carwash/")
public class BookingController {
    @Autowired
    public final BookingService bookingService;

    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("/user/booking/add")
    public ResponseEntity<String> addNewBooking(@RequestBody Booking booking){
        if(bookingService.addNewBooking(booking))
           return new ResponseEntity<>("Successfully Register", HttpStatus.ACCEPTED);
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unsuccessfully Registered");
    }

    @GetMapping({"/user/booking","/admin/booking"})
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.getAllBookings(),HttpStatus.ACCEPTED);
    }

    @PutMapping("/admin/booking/approval")
    public ResponseEntity<String> updateBooking(@RequestBody Booking booking){
        if (bookingService.updateBooking(booking)){
            return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unsuccessfully");
    }

    @GetMapping("/user/booking/{id}")
    public ResponseEntity<List<Booking>> getBookingStatus(@PathVariable("id") Long id){
        return new ResponseEntity<>(bookingService.getAllBookingsById(id),HttpStatus.OK);
    }

    @GetMapping({"admin/booking/availability/{date}","user/booking/availability/{date}"})
    public ResponseEntity<Integer> getBookingAvailability(@PathVariable("date") String date){
        return new ResponseEntity<>(bookingService.getBookingAvailability(date),HttpStatus.OK);
    }

    @GetMapping("admin/booking/place/{place}")
    public ResponseEntity<List<Booking>> getBookingsByPlace(@PathVariable("place") String place){
        return new ResponseEntity<>(bookingService.getBookingsByPlace(place),HttpStatus.OK);
    }

    @GetMapping("admin/booking/date/{date}")
    public ResponseEntity<List<Booking>> getBookingsByDate(@PathVariable("date") String date){
        return new ResponseEntity<>(bookingService.getBookingsByDate(date),HttpStatus.OK);
    }

}
