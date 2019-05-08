package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.BillingAccountEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BillingAccountRepository extends CrudRepository<BillingAccountEntity, Long> {
    Optional<BillingAccountEntity> findByWalletId(Long walletId);
    Iterable<BillingAccountEntity> findAllByUserProfile(UserProfileEntity userProfileEntity);
}
