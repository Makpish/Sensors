package org.example.VehicleRental.service.branch;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.exception.BranchNotFoundException;

import java.util.List;

public interface BranchService {
    boolean onboardNewBranch(String branchName, List<String> allowedVehicleTypes);

    Branch getBranch(String branchName) throws BranchNotFoundException;
}
