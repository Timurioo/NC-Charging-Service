package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {

    List<UserProfileEntity> findAll();
    Optional<UserProfileEntity> findByEmail(String email);
    UserProfileEntity save(UserProfileEntity user);
    void delete(Long id);
    Optional<UserProfileEntity> findById(long id);
}

