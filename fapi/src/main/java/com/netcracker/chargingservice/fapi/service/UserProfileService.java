package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.models.UserProfile;

import java.util.List;

public interface UserProfileService {

    RegisterUser findByEmail(String email);
    RegisterUser findById(Long id);
    List<RegisterUser> findAll();
    RegisterUser save(RegisterUser user);
    String getUsername(String token);
    List<UserProfile> findByRole(Long id);
    void blockUser(Long id);
    void activateUser(Long id);
}
