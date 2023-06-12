package com.example.bookingSystem.app.model;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "bookings" , schema = "my_schema")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private String bookingDoctor;

    private String bookingCustomer;

    private Double bookingPrice;

}
