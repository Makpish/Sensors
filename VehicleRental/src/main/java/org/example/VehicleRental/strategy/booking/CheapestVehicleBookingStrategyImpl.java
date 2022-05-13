package org.example.VehicleRental.strategy.booking;

import org.example.VehicleRental.entity.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CheapestVehicleBookingStrategyImpl implements VehicleBookingStrategy {
    @Override
    public Optional<Vehicle> getVehicle(List<Vehicle> vehicles) {
        return vehicles.stream().min(Comparator.comparingDouble(Vehicle::getPrice));
    }
}
