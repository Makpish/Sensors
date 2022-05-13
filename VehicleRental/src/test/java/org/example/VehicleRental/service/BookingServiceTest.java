package org.example.VehicleRental.service;

import org.example.VehicleRental.helper.VehicleRentalHelper;
import org.example.VehicleRental.service.booking.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookingServiceTest {

    private BookingService bookingService;

    @Test
    void testBookingVehicle() {
        bookingService = VehicleRentalHelper.dependencyInjector().getBookingService();
        double cost = bookingService.bookVehicle("branch1", "CAR", 1, 2);
        Assertions.assertEquals(500, cost);
    }

    @Test
    void testBookingUnavailableVehicle() {
        bookingService = VehicleRentalHelper.dependencyInjector().getBookingService();
        bookingService.bookVehicle("branch1", "CAR", 1, 2);
        double cost = bookingService.bookVehicle("branch1", "CAR", 1, 2);
        Assertions.assertEquals(-1, cost);
    }

    @Test
    void testInvalidBookingVehicle() {
        bookingService = VehicleRentalHelper.dependencyInjector().getBookingService();
        double cost = bookingService.bookVehicle("branch1", "SCOOTER", 1, 2);
        Assertions.assertEquals(-1, cost);
    }

    @Test
    void testDynamicPricingBookingVehicle() {
        bookingService = VehicleRentalHelper.dependencyInjector().getBookingService();
        bookingService.bookVehicle("branch1", "BIKE", 1, 2);
        bookingService.bookVehicle("branch1", "BIKE", 1, 2);
        bookingService.bookVehicle("branch1", "BIKE", 1, 2);
        bookingService.bookVehicle("branch1", "BIKE", 1, 2);
        double cost = bookingService.bookVehicle("branch1", "BIKE", 1, 2);
        Assertions.assertEquals(55.00, Math.round(cost * 100.0) / 100.0);
    }
}
