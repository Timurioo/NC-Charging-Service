package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer> {
    SubscriptionEntity findByDate(Date date);
}
