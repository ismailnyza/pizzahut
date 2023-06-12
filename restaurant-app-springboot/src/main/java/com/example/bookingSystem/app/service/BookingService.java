package com.example.bookingSystem.app.service;
import com.example.bookingSystem.app.exceptions.ResourceNotFoundException;
import com.example.bookingSystem.app.model.Booking;
import com.example.bookingSystem.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }


    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        booking.setBookingTime(bookingDetails.getBookingTime());
        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setBookingDoctor(bookingDetails.getBookingDoctor());
        booking.setBookingCustomer(bookingDetails.getBookingCustomer());
        booking.setBookingPrice(bookingDetails.getBookingPrice());

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        bookingRepository.delete(booking);
    }

    public String searchBooking(String doctorName , LocalDate date , LocalTime time){
        bookingRepository.findBookingByBookingDateAndBookingTimeAndBookingDoctor(date , time, doctorName);
        return "exists";
    }

}

