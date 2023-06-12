package com.example.bookingSystem.app.repository;

import com.example.bookingSystem.app.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


    @Query("SELECT b FROM Booking b WHERE b.bookingDate = ?1 AND b.bookingTime = ?2 AND b.bookingDoctor = ?3")
    Booking findBookingByBookingDateAndBookingTimeAndBookingDoctor(LocalDate date, LocalTime time, String doctor);
}
