package com.example.bookingSystem.app.Controller;

import com.example.bookingSystem.app.exceptions.ResourceNotFoundException;
import com.example.bookingSystem.app.model.Booking;
import com.example.bookingSystem.app.repository.BookingRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        booking.setBookingTime(bookingDetails.getBookingTime());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setBookingDoctor(bookingDetails.getBookingDoctor());
        booking.setBookingCustomer(bookingDetails.getBookingCustomer());
        booking.setBookingPrice(bookingDetails.getBookingPrice());

        Booking updatedBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        bookingRepository.delete(booking);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public Booking searchBooking(@RequestBody JsonNode request) {
        LocalDate date = LocalDate.parse(request.get("bookingDate").asText());
        LocalTime time = LocalTime.parse(request.get("bookingTime").asText());
        String doctor = request.get("bookingDoctor").asText();
        Booking booking = bookingRepository.findBookingByBookingDateAndBookingTimeAndBookingDoctor(date, time, doctor);
        System.out.println("date:" + date);
        System.out.println("time:" + time);
        System.out.println("doctor:" + doctor);
        System.out.println("booking:" + booking);
        return booking;
    }

}
