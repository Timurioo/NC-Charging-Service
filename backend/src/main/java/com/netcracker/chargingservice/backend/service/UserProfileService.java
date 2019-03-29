package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> findAll();
    UserProfile findByLogin(String login);
    UserProfile save(UserProfile user);
    void delete(long id);
}

