package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionEntity> findAll();
    SubscriptionEntity save(SubscriptionEntity subscription);
    List<SubscriptionEntity> findByBillingAccount(BillingAccountEntity billingAccount);
    void delete(Long id);
}
