package org.example.VehicleRental.command;

import org.example.VehicleRental.service.vehicle.VehicleService;

public class DisplayVehiclesCommandImpl implements Command {

    private final VehicleService vehicleService;
    private final String[] args;

    public DisplayVehiclesCommandImpl(VehicleService vehicleService, String[] args) {
        this.vehicleService = vehicleService;
        this.args = args;
    }

    @Override
    public void execute() {
        String branchName = args[1];
        long startTime = Long.parseLong(args[2]);
        long endTime = Long.parseLong(args[3]);
        System.out.println(vehicleService.displayVehicles(branchName, startTime, endTime));
    }
}
