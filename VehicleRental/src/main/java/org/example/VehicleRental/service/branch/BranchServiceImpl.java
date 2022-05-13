package org.example.VehicleRental.service.branch;

import org.example.VehicleRental.dao.BranchDao;
import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.exception.BranchAlreadyExistsException;
import org.example.VehicleRental.exception.BranchNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BranchServiceImpl implements BranchService {

    private final BranchDao branchDao;

    public BranchServiceImpl(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    @Override
    public boolean onboardNewBranch(String branchName, List<String> allowedVehicleTypes) {
        Set<String> vehicleType = new HashSet<>(allowedVehicleTypes);
        try {
            branchDao.createBranch(branchName, vehicleType);
            return true;
        } catch (BranchAlreadyExistsException e) {
            return false;
        }
    }

    @Override
    public Branch getBranch(String branchName) throws BranchNotFoundException {
        return branchDao.getBranch(branchName);
    }
}
