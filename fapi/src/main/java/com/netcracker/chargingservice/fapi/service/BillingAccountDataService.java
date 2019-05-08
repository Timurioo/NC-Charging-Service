package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.BillingAccount;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccount> getAll();
    BillingAccount getBillingAccountById(Long id);
    BillingAccount saveBillingAccount(BillingAccount account);
    void deleteBillingAccount(Long id);
    BillingAccount getBillingAccountByWalletId(Long walletId);
    List<BillingAccount> getBillingAccountByUser(Long id);
}
