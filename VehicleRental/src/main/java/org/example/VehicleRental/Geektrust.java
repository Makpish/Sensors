package org.example.VehicleRental;

import org.example.VehicleRental.entity.RentalCompany;
import org.example.VehicleRental.enums.InputCommandType;
import org.example.VehicleRental.factory.command.CommandFactory;
import org.example.VehicleRental.factory.command.CommandFactoryImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Geektrust {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        List<String> commands = readFile(filePath);
        DependencyInjector dependencyInjector = new DependencyInjector(rentalCompanyDBCreate());
        CommandFactory commandFactory = new CommandFactoryImpl(dependencyInjector);
        commands.forEach(command -> {
            String[] commandArgs = command.split(" ");
            InputCommandType commandType = InputCommandType.valueOf(commandArgs[0]);
            commandFactory.getInputCommandAction(commandType, commandArgs).execute();
        });
    }

    public static List<String> readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            List<String> commands = new ArrayList<>();

            while (fileScanner.hasNext()) {
                commands.add(fileScanner.nextLine());
            }
            return commands;
        }
    }

    public static RentalCompany rentalCompanyDBCreate() {
        return new RentalCompany();
    }
}
