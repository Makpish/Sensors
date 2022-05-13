package org.example.VehicleRental.factory.command;

import org.example.VehicleRental.DependencyInjector;
import org.example.VehicleRental.command.*;
import org.example.VehicleRental.enums.InputCommandType;
import org.example.VehicleRental.exception.InvalidInputException;

public class CommandFactoryImpl implements CommandFactory {

    private final DependencyInjector dependencyInjector;

    public CommandFactoryImpl(DependencyInjector dependencyInjector) {
        this.dependencyInjector = dependencyInjector;
    }

    @Override
    public Command getInputCommandAction(InputCommandType inputCommandType, String[] args) {
        switch (inputCommandType) {
            case ADD_BRANCH:
                return new AddBranchCommandImpl(dependencyInjector.getBranchService(), args);
            case ADD_VEHICLE:
                return new AddVehicleCommandImpl(dependencyInjector.getVehicleService(), args);
            case BOOK:
                return new BookCommandImpl(dependencyInjector.getBookingService(), args);
            case DISPLAY_VEHICLES:
                return new DisplayVehiclesCommandImpl(dependencyInjector.getVehicleService(), args);
        }
        throw new InvalidInputException("Invalid Command");
    }
}
