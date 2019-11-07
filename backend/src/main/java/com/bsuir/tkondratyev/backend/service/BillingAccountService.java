package com.bsuir.tkondratyev.backend.service;

import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;

import java.util.Optional;

public interface BillingAccountService {
    BillingAccountEntity saveBillingAccount(BillingAccountEntity account);
    Optional<BillingAccountEntity> getBillingAccountById(Long id);
    Iterable<BillingAccountEntity> getAllBillingAccounts();
    void deleteBillingAccount(Long id);
    Optional<BillingAccountEntity> getByWalletId(Long walletId);
    Iterable<BillingAccountEntity> getAllByUserProfile(UserProfileEntity userProfileId);
}
