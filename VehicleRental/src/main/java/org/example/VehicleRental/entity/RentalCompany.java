package org.example.VehicleRental.entity;

import java.util.HashMap;
import java.util.Map;

public class RentalCompany {
    private Map<String, Branch> branches;

    public RentalCompany() {
        this.branches = new HashMap<>();
    }

    public Map<String, Branch> getBranches() {
        return branches;
    }

    public boolean branchExists(String branchName) {
        return this.branches.containsKey(branchName);
    }
}
