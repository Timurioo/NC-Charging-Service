package com.netcracker.chargingservice.fapi.models;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserConverterToUserProfile implements Converter<RegisterUser, UserProfile> {

    @Override
    public UserProfile convert(RegisterUser registerUser) {
        UserProfile userProfile = new UserProfile();

        userProfile.setId(registerUser.getId());
        userProfile.setEmail(registerUser.getEmail());
        userProfile.setFirstName(registerUser.getFirstName());
        userProfile.setLastName(registerUser.getLastName());
        userProfile.setRole(registerUser.getRole());


        return userProfile;
    }
}
