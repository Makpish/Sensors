package org.example.VehicleRental.strategy.booking;

import org.example.VehicleRental.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleBookingStrategy {
    Optional<Vehicle> getVehicle(List<Vehicle> vehicles);
}
