package com.bsuir.tkondratyev.backend.repository;

import com.bsuir.tkondratyev.backend.entity.BillingAccountEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BillingAccountRepository extends CrudRepository<BillingAccountEntity, Long> {
    Optional<BillingAccountEntity> findByWalletId(Long walletId);
    Iterable<BillingAccountEntity> findAllByUserProfile(UserProfileEntity userProfileEntity);
}
