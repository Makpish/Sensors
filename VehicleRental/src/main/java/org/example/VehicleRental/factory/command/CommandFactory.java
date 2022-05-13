package org.example.VehicleRental.factory.command;

import org.example.VehicleRental.command.Command;
import org.example.VehicleRental.enums.InputCommandType;

public interface CommandFactory {

    Command getInputCommandAction(InputCommandType inputCommandType, String[] args);
}
