package org.example.VehicleRental.dao;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.entity.RentalCompany;
import org.example.VehicleRental.exception.BranchAlreadyExistsException;
import org.example.VehicleRental.exception.BranchNotFoundException;
import org.example.VehicleRental.factory.branch.BranchFactory;

import java.util.Set;

public class BranchDao {

    private final RentalCompany rentalCompany;
    private final BranchFactory branchFactory;

    public BranchDao(RentalCompany rentalCompany, BranchFactory branchFactory) {
        this.rentalCompany = rentalCompany;
        this.branchFactory = branchFactory;
    }

    public Branch createBranch(String branchName, Set<String> vehicleTypes) throws BranchAlreadyExistsException {
        if (rentalCompany.branchExists(branchName))
            throw new BranchAlreadyExistsException("Cannot add existing branch");
        rentalCompany.getBranches().put(branchName, branchFactory.createBranch(branchName, vehicleTypes));
        return rentalCompany.getBranches().get(branchName);
    }

    public Branch getBranch(String branchName) throws BranchNotFoundException {
        if (!rentalCompany.branchExists(branchName))
            throw new BranchNotFoundException("Branch Does Not Exists");
        return rentalCompany.getBranches().get(branchName);
    }
}
