package org.example.VehicleRental;

import org.example.VehicleRental.dao.BranchDao;
import org.example.VehicleRental.entity.RentalCompany;
import org.example.VehicleRental.factory.branch.BranchFactory;
import org.example.VehicleRental.factory.vehicle.VehicleFactory;
import org.example.VehicleRental.service.booking.BookingService;
import org.example.VehicleRental.service.booking.BookingServiceImpl;
import org.example.VehicleRental.service.branch.BranchService;
import org.example.VehicleRental.service.branch.BranchServiceImpl;
import org.example.VehicleRental.service.dynamicPricing.DynamicPricingRateService;
import org.example.VehicleRental.service.dynamicPricing.DynamicPricingRateServiceImpl;
import org.example.VehicleRental.service.vehicle.VehicleService;
import org.example.VehicleRental.service.vehicle.VehicleServiceImpl;
import org.example.VehicleRental.service.vehiclePricing.VehiclePricingService;
import org.example.VehicleRental.service.vehiclePricing.VehiclePricingServiceImpl;
import org.example.VehicleRental.strategy.booking.CheapestVehicleBookingStrategyImpl;
import org.example.VehicleRental.strategy.booking.VehicleBookingStrategy;

public class DependencyInjector {
    private final BranchDao branchDao;
    private final BranchFactory branchFactory;
    private final VehicleFactory vehicleFactory;
    private final BookingService bookingService;
    private final BranchService branchService;
    private final DynamicPricingRateService dynamicPricingRateService;
    private final VehicleService vehicleService;
    private final VehiclePricingService vehiclePricingService;
    private final VehicleBookingStrategy vehicleBookingStrategy;

    public DependencyInjector(RentalCompany rentalCompany) {
        this.branchFactory = new BranchFactory();
        this.branchDao = new BranchDao(rentalCompany, branchFactory);
        this.vehicleFactory = new VehicleFactory();
        this.branchService = new BranchServiceImpl(this.branchDao);
        this.dynamicPricingRateService = new DynamicPricingRateServiceImpl();
        this.vehicleService = new VehicleServiceImpl(this.branchService, this.vehicleFactory);
        this.vehiclePricingService = new VehiclePricingServiceImpl();
        this.vehicleBookingStrategy = new CheapestVehicleBookingStrategyImpl();
        this.bookingService = new BookingServiceImpl(this.branchService, this.vehicleBookingStrategy, this.vehiclePricingService, this.dynamicPricingRateService);
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public BranchService getBranchService() {
        return branchService;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }
}
