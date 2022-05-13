package org.example.VehicleRental.command;

import org.example.VehicleRental.service.booking.BookingService;

public class BookCommandImpl implements Command {

    private final BookingService bookingService;
    private final String[] args;

    public BookCommandImpl(BookingService bookingService, String[] args) {
        this.bookingService = bookingService;
        this.args = args;
    }

    @Override
    public void execute() {
        String branchName = args[1];
        String vehicleType = args[2];
        long startTime = Long.parseLong(args[3]);
        long endTime = Long.parseLong(args[4]);
        System.out.println((int) bookingService.bookVehicle(branchName, vehicleType, startTime, endTime));
    }
}
