package com.example.bookingSystem.app.Controller;

public class BookingSearchRequest {
    private String bookingDate;
    private String bookingTime;
    private String bookingDoctor;
    public BookingSearchRequest() {
    }

    public BookingSearchRequest(String bookingDate, String bookingTime, String bookingDoctor) {
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.bookingDoctor = bookingDoctor;
    }

    // Getters and Setters
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDoctor() {
        return bookingDoctor;
    }

    public void setBookingDoctor(String bookingDoctor) {
        this.bookingDoctor = bookingDoctor;
    }



}
