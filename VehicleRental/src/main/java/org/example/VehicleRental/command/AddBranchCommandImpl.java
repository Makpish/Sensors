package org.example.VehicleRental.command;

import org.example.VehicleRental.service.branch.BranchService;

import java.util.Arrays;
import java.util.List;

public class AddBranchCommandImpl implements Command {

    private final BranchService branchService;
    private final String[] args;

    public AddBranchCommandImpl(BranchService branchService, String[] args) {
        this.branchService = branchService;
        this.args = args;
    }

    @Override
    public void execute() {
        String branchName = this.args[1];
        List<String> vehicleTypes = Arrays.asList(this.args[2].split(","));
        System.out.println(branchService.onboardNewBranch(branchName, vehicleTypes) ? "TRUE" : "FALSE");
    }
}
