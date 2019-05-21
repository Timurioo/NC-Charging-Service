package com.netcracker.chargingservice.fapi.converters;

import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.models.UserProfile;
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
        userProfile.setIsBlocked(registerUser.getIsBlocked());


        return userProfile;
    }
}
