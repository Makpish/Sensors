package org.example.VehicleRental.service.dynamicPricing;

public interface DynamicPricingRateService {
    double getHikedPrice(long availableVehicleCount, long totalVehicleCount, double price);
}
