package org.example.VehicleRental.service.vehiclePricing;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.TimeSlot;
import org.example.VehicleRental.entity.Vehicle;

public class VehiclePricingServiceImpl implements VehiclePricingService {
    @Override
    public double getPrice(Branch branch, Vehicle vehicle, TimeSlot timeSlot) {
        return vehicle.getPrice() * timeSlot.getTimeUnits();
    }
}
