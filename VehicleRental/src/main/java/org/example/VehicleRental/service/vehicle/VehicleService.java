package org.example.VehicleRental.service.vehicle;

public interface VehicleService {
    boolean addVehicles(String branchName, String vehicleType, String vehicleId, double price);

    String displayVehicles(String branchName, long startTime, long endTime);
}
