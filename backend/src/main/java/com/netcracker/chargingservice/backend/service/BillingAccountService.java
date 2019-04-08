package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;

import java.util.List;
import java.util.Optional;

public interface BillingAccountService {
    BillingAccountEntity saveBillingAccount(BillingAccountEntity account);
    Optional<BillingAccountEntity> getBillingAccountById(Integer id);
    Iterable<BillingAccountEntity> getAllBillingAccounts();
    void deleteBillingAccount(Integer id);
}
