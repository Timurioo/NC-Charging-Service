package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface BillingAccountRepository extends CrudRepository<BillingAccountEntity, Long> {
}
