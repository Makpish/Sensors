package org.example.VehicleRental.entity;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String vehicleType;
    private String name;
    private double price;
    private List<TimeSlot> bookings;


    public Vehicle(String vehicleType, String name, double price) {
        this.vehicleType = vehicleType;
        this.name = name;
        this.price = price;
        this.bookings = new ArrayList<>();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addBooking(TimeSlot timeSlot) {
        this.bookings.add(timeSlot);
    }

    public boolean canBook(TimeSlot timeSlot) {
        return this.bookings.stream().noneMatch(booking -> booking.isOverLapping(timeSlot));
    }
}
