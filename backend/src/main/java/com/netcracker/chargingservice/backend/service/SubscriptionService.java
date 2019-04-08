package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.SubscriptionEntity;

import java.util.Date;
import java.util.List;

public interface SubscriptionService {
    List<SubscriptionEntity> findAll();
    SubscriptionEntity findByDate(Date date);
    SubscriptionEntity save(SubscriptionEntity subscription);
    void delete(Integer id);
}
