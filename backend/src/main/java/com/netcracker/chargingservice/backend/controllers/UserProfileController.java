package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(path="/signup")
    public UserProfileEntity saveUser(@RequestBody UserProfileEntity userProfileEntity) {
        return userProfileService.save(userProfileEntity);
    }

    @GetMapping(path="id/{id}")
    public ResponseEntity<UserProfileEntity> getUserById(@PathVariable(name="id") Long id) {
       Optional<UserProfileEntity> user = userProfileService.findById(id);
       return user.map(ResponseEntity::ok).orElse(null);
    }

    @GetMapping(path="/all")
    public @ResponseBody List<UserProfileEntity> getAll() {
        return userProfileService.findAll();
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<UserProfileEntity> getUserByEmail(@PathVariable(name = "email") String email) {
        Optional<UserProfileEntity> user = userProfileService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElse(null);
    }
}
