package com.bsuir.tkondratyev.backend.service;

import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionEntity> findAll();
    SubscriptionEntity save(SubscriptionEntity subscription);
    List<SubscriptionEntity> findByBillingAccount(BillingAccountEntity billingAccount);
    void delete(Long id);
}
