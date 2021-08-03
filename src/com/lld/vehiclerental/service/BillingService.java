package com.lld.vehiclerental.service;

import com.lld.vehiclerental.model.BillReceipt;
import com.lld.vehiclerental.repository.BillingRepository;

import java.util.List;

public class BillingService {
    public BillingRepository billingRepository;

    public BillingService() {
        billingRepository = new BillingRepository();
    }

    public BillReceipt generateBillReceipt(String bookingId, Double pricePerHour, String userId, String branchId, String vehicleId, Integer startTime, Integer endTime) {
        Double amount = pricePerHour * (endTime - startTime);
        return billingRepository.generateBillReceipt(bookingId, amount, userId, branchId, vehicleId, startTime, endTime);
    }

    public List<BillReceipt> getAllBillReceipts() {
        return billingRepository.getAllBillReceipts();
    }
}
