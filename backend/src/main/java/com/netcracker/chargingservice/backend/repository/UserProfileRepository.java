package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Integer> {
    UserProfileEntity findByLogin(String login);
}
