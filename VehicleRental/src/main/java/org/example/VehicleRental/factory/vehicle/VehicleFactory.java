package org.example.VehicleRental.factory.vehicle;

import org.example.VehicleRental.entity.Vehicle;

public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType, String vehicleId, double price) {
        return new Vehicle(vehicleType, vehicleId, price);
    }
}
