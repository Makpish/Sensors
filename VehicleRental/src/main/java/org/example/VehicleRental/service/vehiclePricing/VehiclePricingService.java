package org.example.VehicleRental.service.vehiclePricing;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.TimeSlot;
import org.example.VehicleRental.entity.Vehicle;

public interface VehiclePricingService {
    double getPrice(Branch branch, Vehicle vehicle, TimeSlot timeSlot);
}
