package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.UserProfile;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserProfile> getAllUsers(){
        return userProfileService.findAll();
    }

    @GetMapping("/login/{login}")
    public UserProfile getUserByLogin(@PathVariable String login) {
        return userProfileService.findByLogin(login);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    public UserProfile saveUser(@RequestBody UserProfile userProfile){
        return userProfileService.save(userProfile);
    }
}
