package org.example.VehicleRental.service;

import org.example.VehicleRental.entity.Branch;
import org.example.VehicleRental.exception.BranchNotFoundException;
import org.example.VehicleRental.helper.VehicleRentalHelper;
import org.example.VehicleRental.service.branch.BranchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BranchServiceTest {

    private BranchService branchService;

    @Test
    void testGetBranch() throws BranchNotFoundException {
        branchService = VehicleRentalHelper.dependencyInjector().getBranchService();
        Branch branch = branchService.getBranch("branch1");
        Assertions.assertEquals("branch1", branch.getBranchName());
    }

    @Test
    void testGetBranchError() throws BranchNotFoundException {
        branchService = VehicleRentalHelper.dependencyInjector().getBranchService();
        Assertions.assertThrows(BranchNotFoundException.class, () -> branchService.getBranch("branch2"));
    }

    @Test
    void testOnBoardBranch() {
        branchService = VehicleRentalHelper.dependencyInjector().getBranchService();
        boolean added = branchService.onboardNewBranch("branch3", Arrays.asList("CAR", "VAN"));
        Assertions.assertTrue(added);
    }

    @Test
    void testOnBoardBranchFailure() {
        branchService = VehicleRentalHelper.dependencyInjector().getBranchService();
        boolean added = branchService.onboardNewBranch("branch1", Arrays.asList("CAR", "VAN"));
        Assertions.assertFalse(added);
    }

}
