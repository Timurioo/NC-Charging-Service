package com.netcracker.chargingservice.fapi.converters;

import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.models.UserProfile;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserProfileConverterToRegisterUser implements Converter<UserProfile, RegisterUser> {

    @Autowired
    UserProfileService userProfileService;


    @Override
    public RegisterUser convert(UserProfile userProfile) {

        RegisterUser registerUser = new RegisterUser();

        registerUser.setId(userProfile.getId());
        registerUser.setFirstName(userProfile.getFirstName());
        registerUser.setLastName(userProfile.getLastName());
        registerUser.setEmail(userProfile.getEmail());
        registerUser.setRole(userProfile.getRole());
        registerUser.setBlocked(userProfile.getIsBlocked());
        registerUser.setPassword(userProfileService.findByEmail(userProfile.getEmail()).getPassword());

        return registerUser;
    }
}
