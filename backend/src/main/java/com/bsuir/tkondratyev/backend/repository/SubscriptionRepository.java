package com.bsuir.tkondratyev.backend.repository;

import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {
    List<SubscriptionEntity> findByBillingAccount(BillingAccountEntity billingAccount);
}
