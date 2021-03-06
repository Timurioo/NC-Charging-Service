package com.bsuir.tkondratyev.backend.service.impl;

import com.bsuir.tkondratyev.backend.repository.BillingAccountRepository;
import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;
import com.bsuir.tkondratyev.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {

    @Autowired
    private BillingAccountRepository billingAccountRepository;


    @Override
    public BillingAccountEntity saveBillingAccount(BillingAccountEntity account) {
        boolean forComparison = billingAccountRepository.findByWalletId(account.getWalletId()).isPresent();
        if (account.getWalletId() != null || !forComparison) {
            return billingAccountRepository.save(account);
        } else return null;
    }

    @Override
    public Iterable<BillingAccountEntity> getAllByUserProfile(UserProfileEntity userProfile) {
        return billingAccountRepository.findAllByUserProfile(userProfile);
    }

    @Override
    public Optional<BillingAccountEntity> getBillingAccountById(Long id) {
        return billingAccountRepository.findById(id);
    }

    @Override
    public Iterable<BillingAccountEntity> getAllBillingAccounts() {
       return billingAccountRepository.findAll();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        billingAccountRepository.deleteById(id);
    }

    @Override
    public Optional<BillingAccountEntity> getByWalletId(Long walletId) {
        return billingAccountRepository.findByWalletId(walletId);
    }
}
