package org.example.VehicleRental.service.dynamicPricing;


public class DynamicPricingRateServiceImpl implements DynamicPricingRateService {
    @Override
    public double getHikedPrice(long availableVehicleCount, long totalVehicleCount, double price) {
        double dynamicPricingRate = 1.0;
        if (0.2 >= (double) availableVehicleCount / totalVehicleCount)
            dynamicPricingRate = 1.1;
        return dynamicPricingRate * price;
    }
}
