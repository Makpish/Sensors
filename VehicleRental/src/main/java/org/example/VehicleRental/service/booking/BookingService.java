package org.example.VehicleRental.service.booking;

public interface BookingService {
    double bookVehicle(String branchName, String vehicleType, long startTime, long endTime);
}
