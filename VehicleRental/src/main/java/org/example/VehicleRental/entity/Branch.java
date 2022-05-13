package org.example.VehicleRental.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Branch {
    private String branchName;
    private List<Vehicle> vehicles;
    private Set<String> allowedVehicleTypes;

    public Branch(String branchName, Set<String> allowedVehicleTypes) {
        this.branchName = branchName;
        this.vehicles = new ArrayList<>();
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public boolean isVehicleTypeValidForBranch(String vehicleType) {
        return this.allowedVehicleTypes.contains(vehicleType);
    }

    public boolean addNewVehicle(Vehicle vehicle) {
        return this.vehicles.add(vehicle);
    }

    public List<Vehicle> findAllAvailableVehiclesByType(String vehicleType, TimeSlot timeSlot) {
        return this.vehicles.stream().filter(
                        vehicle -> vehicle.getVehicleType().equals(vehicleType) && vehicle.canBook(timeSlot))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findAllVehiclesByType(String vehicleType) {
        return this.vehicles.stream().filter(
                        vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findAllVehiclesByTime(TimeSlot timeSlot) {
        return this.vehicles.stream().filter(
                        vehicle -> vehicle.canBook(timeSlot))
                .collect(Collectors.toList());
    }
}
