package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.converters.UserProfileConverterToRegisterUser;
import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.models.UserProfile;
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

    @Autowired
    private UserProfileConverterToRegisterUser converter;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<RegisterUser> getAllUsers() {
        return userProfileService.findAll();
    }

    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
    public RegisterUser saveUser(@RequestBody RegisterUser registerUser) {
        return userProfileService.save(registerUser);
    }

//    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'COMPANY')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/role/{id}")
    public ResponseEntity<List<UserProfile>> getByRole(@PathVariable(name = "id") Long id) {
        List<UserProfile> users = userProfileService.findByRole(id);
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/block/id/{id}")
    public ResponseEntity blockUser(@PathVariable (name = "id") Long id){
        userProfileService.blockUser(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/activate/id/{id}")
    public ResponseEntity activate(@PathVariable (name = "id") Long id){
        userProfileService.activateUser(id);
        return ResponseEntity.ok().build();
    }
}
