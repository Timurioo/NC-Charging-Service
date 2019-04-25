package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Long> {
    Optional<UserProfileEntity> findByEmail(String email);
}
