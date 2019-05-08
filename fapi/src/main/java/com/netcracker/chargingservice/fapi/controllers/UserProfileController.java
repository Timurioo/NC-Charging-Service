package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<RegisterUser> getAllUsers(){
        return userProfileService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/signup", method = RequestMethod.POST, produces = "application/json")
    public RegisterUser saveUser(@RequestBody RegisterUser registerUser){
        return userProfileService.save(registerUser);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<Boolean> checkExistingByEmail(@PathVariable(name = "email") String email) {
        RegisterUser user = userProfileService.findByEmail(email);
        if (user == null) return ResponseEntity.ok(false);
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RegisterUser> getUserById(@PathVariable(name = "id") Long id) {
        RegisterUser user = userProfileService.findById(id);
        return user != null ? ResponseEntity.ok(user) : null;
    }
}
