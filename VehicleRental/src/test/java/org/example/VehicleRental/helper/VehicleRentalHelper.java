package org.example.VehicleRental.helper;

import org.example.VehicleRental.DependencyInjector;
import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.RentalCompany;
import org.example.VehicleRental.entity.TimeSlot;
import org.example.VehicleRental.entity.Vehicle;
import org.example.VehicleRental.factory.command.CommandFactory;
import org.example.VehicleRental.factory.command.CommandFactoryImpl;

import java.util.HashSet;

public class VehicleRentalHelper {

    public static RentalCompany getRentalCompany() {
        RentalCompany rentalCompany = new RentalCompany();
        rentalCompany.getBranches().put("branch1", new Branch("branch1", new HashSet<String>() {{
            add("CAR");
            add("BIKE");
        }}));
        Vehicle vehicle = new Vehicle("CAR", "car1", 500);
        vehicle.addBooking(new TimeSlot(4, 5));
        rentalCompany.getBranches().get("branch1").addNewVehicle(vehicle);

        rentalCompany.getBranches().get("branch1").addNewVehicle(new Vehicle("BIKE", "bike1", 50));
        rentalCompany.getBranches().get("branch1").addNewVehicle(new Vehicle("BIKE", "bike2", 50));
        rentalCompany.getBranches().get("branch1").addNewVehicle(new Vehicle("BIKE", "bike3", 50));
        rentalCompany.getBranches().get("branch1").addNewVehicle(new Vehicle("BIKE", "bike4", 50));
        rentalCompany.getBranches().get("branch1").addNewVehicle(new Vehicle("BIKE", "bike5", 50));

        return rentalCompany;
    }

    public static DependencyInjector dependencyInjector() {
        DependencyInjector dependencyInjector = new DependencyInjector(getRentalCompany());
        return dependencyInjector;
    }

    public static CommandFactory commandFactory() {
        CommandFactory commandFactory = new CommandFactoryImpl(dependencyInjector());
        return commandFactory;
    }
}
