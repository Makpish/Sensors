package org.example.VehicleRental.command;

import org.example.VehicleRental.enums.InputCommandType;
import org.example.VehicleRental.factory.command.CommandFactory;
import org.example.VehicleRental.helper.VehicleRentalHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CommandTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private CommandFactory commandFactory;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void addBranchCommandTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "ADD_BRANCH branch2 CAR,BIKE,VAN";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        commandFactory.getInputCommandAction(commandType, commandArgs).execute();
        Assertions.assertEquals("TRUE", outputStreamCaptor.toString().trim());
    }

    @Test
    void addVehicleCommandTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "ADD_VEHICLE branch1 CAR V1 500";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        commandFactory.getInputCommandAction(commandType, commandArgs).execute();
        Assertions.assertEquals("TRUE", outputStreamCaptor.toString().trim());
    }

    @Test
    void bookCommandTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "BOOK branch1 CAR 1 5";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        commandFactory.getInputCommandAction(commandType, commandArgs).execute();
        Assertions.assertEquals("-1", outputStreamCaptor.toString().trim());
    }

    @Test
    void displayCommandTest() {
        commandFactory = VehicleRentalHelper.commandFactory();
        String command = "DISPLAY_VEHICLES branch1 1 5";
        String[] commandArgs = command.split(" ");
        InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
        commandFactory.getInputCommandAction(commandType, commandArgs).execute();
        Assertions.assertEquals("bike1,bike2,bike3,bike4,bike5", outputStreamCaptor.toString().trim());
    }
}
