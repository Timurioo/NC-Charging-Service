package com.netcracker.chargingservice.fapi.service;

import com.netcracker.chargingservice.fapi.models.RegisterUser;

import java.util.List;

public interface UserProfileService {

    RegisterUser findByEmail(String email);
    RegisterUser findById(long id);
    List<RegisterUser> findAll();
    RegisterUser save(RegisterUser user);
    String getUsername(String token);
}
