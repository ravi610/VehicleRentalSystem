package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.RentalBranch;
import com.lld.vehiclerental.repository.BranchRepository;

import java.util.List;

public class BranchService {
    private BranchRepository branchRepository;

    public BranchService() {
        branchRepository = new BranchRepository();
    }

    public RentalBranch onboardBranch(String city, String branchName) {
        return branchRepository.createBranch(city, branchName);
    }

    public String offBoardBranch(String city, String branchName) {
        return branchRepository.deleteBranch(city, branchName);
    }

    public List<RentalBranch> getAllBranches() {
        return branchRepository.getAllBranches();
    }
}
