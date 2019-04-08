package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findByLogin(String login);
    List<UserProfile> findAll();
    UserProfile save(UserProfile user);
}
