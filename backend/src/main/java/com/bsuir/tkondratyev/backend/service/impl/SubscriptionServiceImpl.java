package com.bsuir.tkondratyev.backend.service.impl;

import com.bsuir.tkondratyev.backend.repository.SubscriptionRepository;
import com.bsuir.tkondratyev.backend.service.SubscriptionService;
import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.SubscriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<SubscriptionEntity> findAll() {
        return (List<SubscriptionEntity>) subscriptionRepository.findAll();
    }

    @Override
    public SubscriptionEntity save(SubscriptionEntity subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<SubscriptionEntity> findByBillingAccount(BillingAccountEntity billingAccount) {
        return subscriptionRepository.findByBillingAccount(billingAccount);
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
