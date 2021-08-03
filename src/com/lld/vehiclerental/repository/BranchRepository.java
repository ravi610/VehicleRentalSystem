package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.RentalBranch;

import java.util.ArrayList;
import java.util.List;

public class BranchRepository {
    List<RentalBranch> branches;

    public BranchRepository() {
        branches = new ArrayList<>();
    }

    public RentalBranch createBranch(String city, String branchName) {
        RentalBranch newBranch = new RentalBranch(city, branchName);
        branches.add(newBranch);
        return newBranch;
    }

    public String deleteBranch(String city, String branchName) {
        for (RentalBranch branch : branches) {
            if (branch.getBranchName().equals(branchName) && branch.getCity().equals(city)) {
                branches.remove(branch);
                return branch.getRentalBranchId();
            }
        }

        return null;
    }

    public RentalBranch getBranchByCityAndBranchName(String city, String branchName) {
        for (RentalBranch branch : branches) {
            if (branch.getBranchName().equals(branchName) && branch.getCity().equals(city)) {
                return branch;
            }
        }

        return null;
    }

    public List<RentalBranch> getAllBranches() {
        return branches;
    }
}
