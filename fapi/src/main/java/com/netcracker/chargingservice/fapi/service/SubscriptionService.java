package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findAll();
    Subscription save(Subscription subscription);
    List<Subscription> findByBillingAccount(Long id);
    void delete(Long id);
}
