package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findByEmail(String email);
    List<UserProfile> findAll();
    UserProfile save(UserProfile user);
}
