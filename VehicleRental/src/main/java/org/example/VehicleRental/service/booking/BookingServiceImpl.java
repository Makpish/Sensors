package org.example.VehicleRental.service.booking;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.TimeSlot;
import org.example.VehicleRental.entity.Vehicle;
import org.example.VehicleRental.exception.BranchNotFoundException;
import org.example.VehicleRental.service.branch.BranchService;
import org.example.VehicleRental.service.dynamicPricing.DynamicPricingRateService;
import org.example.VehicleRental.service.vehiclePricing.VehiclePricingService;
import org.example.VehicleRental.strategy.booking.VehicleBookingStrategy;

import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {

    private final BranchService branchService;
    private final VehicleBookingStrategy vehicleBookingStrategy;
    private final VehiclePricingService vehiclePricingService;
    private final DynamicPricingRateService dynamicPricingRateService;

    public BookingServiceImpl(BranchService branchService, VehicleBookingStrategy vehicleBookingStrategy,
                              VehiclePricingService vehiclePricingService, DynamicPricingRateService dynamicPricingRateService) {
        this.branchService = branchService;
        this.vehicleBookingStrategy = vehicleBookingStrategy;
        this.vehiclePricingService = vehiclePricingService;
        this.dynamicPricingRateService = dynamicPricingRateService;
    }

    @Override
    public double bookVehicle(String branchName, String vehicleType, long startTime, long endTime) {
        Branch branch;
        try {
            branch = branchService.getBranch(branchName);
            TimeSlot timeSlot = new TimeSlot(startTime, endTime);
            List<Vehicle> availableVehicles = branch.findAllAvailableVehiclesByType(vehicleType, timeSlot);
            Optional<Vehicle> vehicleOptional = vehicleBookingStrategy.getVehicle(availableVehicles);
            if (vehicleOptional.isPresent()) {
                vehicleOptional.get().addBooking(timeSlot);
                return dynamicPricingRateService.getHikedPrice(availableVehicles.size(), branch.findAllVehiclesByType(vehicleType).size(),
                        vehiclePricingService.getPrice(branch, vehicleOptional.get(), timeSlot));
            }
        } catch (BranchNotFoundException e) {
        }
        return -1;
    }
}
