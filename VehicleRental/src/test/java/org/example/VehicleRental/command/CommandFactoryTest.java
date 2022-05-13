package org.example.VehicleRental.command;

import org.example.VehicleRental.enums.InputCommandType;
import org.example.VehicleRental.factory.command.CommandFactory;
import org.example.VehicleRental.helper.VehicleRentalHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {
    private CommandFactory commandFactory;


    @Test
    void addBranchCommandFactoryTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "ADD_BRANCH branch2 CAR,BIKE,VAN";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        Command command1 = commandFactory.getInputCommandAction(commandType, commandArgs);
        Assertions.assertEquals(AddBranchCommandImpl.class, command1.getClass());
    }

    @Test
    void addVehicleCommandFactoryTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "ADD_VEHICLE branch1 CAR V1 500";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        Command command1 = commandFactory.getInputCommandAction(commandType, commandArgs);
        Assertions.assertEquals(AddVehicleCommandImpl.class, command1.getClass());
    }

    @Test
    void bookCommandFactoryTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "BOOK branch1 CAR 1 5";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        Command command1 = commandFactory.getInputCommandAction(commandType, commandArgs);
        Assertions.assertEquals(BookCommandImpl.class, command1.getClass());
    }

    @Test
    void displayCommandFactoryTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "DISPLAY_VEHICLES branch1 1 5";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        Command command1 = commandFactory.getInputCommandAction(commandType, commandArgs);
        Assertions.assertEquals(DisplayVehiclesCommandImpl.class, command1.getClass());
    }

    @Test
    void commandFactoryFailTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "HELLO_WORLD 123";
        String[] commandArgs = command.split(" ");
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputCommandType.valueOf(commandArgs[0]));
    }
}
