package com.lld.vehiclerental.repository;

import com.lld.vehiclerental.model.BillReceipt;

import java.util.ArrayList;
import java.util.List;

public class BillingRepository {
    List<BillReceipt> billReceipts;

    public BillingRepository() {
        billReceipts = new ArrayList<>();
    }

    public BillReceipt generateBillReceipt(String bookingId, Double amount, String userId, String branchId, String vehicleId, Integer startTime, Integer endTime) {
        BillReceipt billReceipt = new BillReceipt(bookingId, amount, userId, branchId, vehicleId, startTime, endTime);
        billReceipts.add(billReceipt);

        return billReceipt;
    }

    public List<BillReceipt> getAllBillReceipts() {
        return billReceipts;
    }
}
