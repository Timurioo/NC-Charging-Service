package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;

import java.util.Optional;

public interface BillingAccountService {
    BillingAccountEntity saveBillingAccount(BillingAccountEntity account);
    Optional<BillingAccountEntity> getBillingAccountById(Long id);
    Iterable<BillingAccountEntity> getAllBillingAccounts();
    void deleteBillingAccount(Long id);
    Optional<BillingAccountEntity> getByWalletId(Long walletId);
    Iterable<BillingAccountEntity> getAllByUserProfile(UserProfileEntity userProfileId);
}
