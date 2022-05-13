package org.example.VehicleRental.service;

import org.example.VehicleRental.helper.VehicleRentalHelper;
import org.example.VehicleRental.service.vehicle.VehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleServiceTest {
    private VehicleService vehicleService;

    @Test
    void addVehiclesTest() {
        vehicleService = VehicleRentalHelper.dependencyInjector().getVehicleService();
        boolean added = vehicleService.addVehicles("branch1", "CAR", "car2", 1000);
        Assertions.assertTrue(added);
    }

    @Test
    void addVehiclesTestFail() {
        vehicleService = VehicleRentalHelper.dependencyInjector().getVehicleService();
        boolean added = vehicleService.addVehicles("branch1", "SCOOTER", "car2", 1000);
        Assertions.assertFalse(added);
    }

    @Test
    void displayVehiclesTest() {
        vehicleService = VehicleRentalHelper.dependencyInjector().getVehicleService();
        String result = vehicleService.displayVehicles("branch1", 1, 2);
        Assertions.assertEquals("bike1,bike2,bike3,bike4,bike5,car1", result);
    }

    @Test
    void displayVehiclesTestClashing() {
        vehicleService = VehicleRentalHelper.dependencyInjector().getVehicleService();
        String result = vehicleService.displayVehicles("branch1", 4, 5);
        Assertions.assertEquals("bike1,bike2,bike3,bike4,bike5", result);
    }
}
