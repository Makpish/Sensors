package org.example.VehicleRental.command;

import org.example.VehicleRental.service.vehicle.VehicleService;

public class AddVehicleCommandImpl implements Command {

    private final VehicleService vehicleService;
    private final String[] args;

    public AddVehicleCommandImpl(VehicleService vehicleService, String[] args) {
        this.vehicleService = vehicleService;
        this.args = args;
    }

    @Override
    public void execute() {
        String branchName = this.args[1];
        String vehicleType = this.args[2];
        String vehicleName = this.args[3];
        long price = Long.parseLong(this.args[4]);
        System.out.println(vehicleService.addVehicles(branchName, vehicleType, vehicleName, price) ? "TRUE" : "FALSE");
    }
}
