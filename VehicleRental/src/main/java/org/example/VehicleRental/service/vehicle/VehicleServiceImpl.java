package org.example.VehicleRental.service.vehicle;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.TimeSlot;
import org.example.VehicleRental.entity.Vehicle;
import org.example.VehicleRental.exception.BranchNotFoundException;
import org.example.VehicleRental.factory.vehicle.VehicleFactory;
import org.example.VehicleRental.service.branch.BranchService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceImpl implements VehicleService {

    private final BranchService branchService;
    private final VehicleFactory vehicleFactory;

    public VehicleServiceImpl(BranchService branchService, VehicleFactory vehicleFactory) {
        this.branchService = branchService;
        this.vehicleFactory = vehicleFactory;
    }

    @Override
    public boolean addVehicles(String branchName, String vehicleType, String vehicleId, double price) {
        Branch branch;
        try {
            branch = branchService.getBranch(branchName);
            if (branch.isVehicleTypeValidForBranch(vehicleType)) {
                return branch.addNewVehicle(vehicleFactory.createVehicle(vehicleType, vehicleId, price));
            }
        } catch (BranchNotFoundException e) {
        }
        return false;
    }

    @Override
    public String displayVehicles(String branchName, long startTime, long endTime) {
        Branch branch;
        try {
            branch = branchService.getBranch(branchName);
            TimeSlot timeSlot = new TimeSlot(startTime, endTime);
            List<Vehicle> availableVehicles = branch.findAllVehiclesByTime(timeSlot);
            if (availableVehicles.isEmpty())
                return "";
            availableVehicles.sort(Comparator.comparing(Vehicle::getPrice));
            return availableVehicles.stream().map(Vehicle::getName).collect(Collectors.joining(","));
        } catch (BranchNotFoundException e) {
        }
        return "";
    }

}
