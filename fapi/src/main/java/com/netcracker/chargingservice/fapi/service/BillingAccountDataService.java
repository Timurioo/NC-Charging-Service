package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.BillingAccountViewModel;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAll();
    BillingAccountViewModel getBillingAccountById(Long id);
    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);
    void deleteBillingAccount(Long id);
}
