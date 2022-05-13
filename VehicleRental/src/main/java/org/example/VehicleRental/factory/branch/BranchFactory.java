package org.example.VehicleRental.factory.branch;

import org.example.VehicleRental.entity.Branch;

import java.util.Set;

public class BranchFactory {

    public Branch createBranch(String branchName, Set<String> vehicleTypes) {
        return new Branch(branchName, vehicleTypes);
    }
}
