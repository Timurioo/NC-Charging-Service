package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;

import java.util.List;

public interface UserProfileService {

    List<UserProfileEntity> findAll();
    UserProfileEntity findByLogin(String login);
    UserProfileEntity save(UserProfileEntity user);
    void delete(Integer id);
}

