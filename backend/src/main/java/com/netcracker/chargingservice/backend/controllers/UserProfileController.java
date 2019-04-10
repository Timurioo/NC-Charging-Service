package com.netcracker.chargingservice.backend.controllers;

import com.netcracker.chargingservice.backend.entity.RoleEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String email, @RequestParam String password,
                                           @RequestParam String login, @RequestParam byte isBlocked, @RequestParam String firstName,
                                           @RequestParam String lastName, @RequestParam RoleEntity rolesId) {
        UserProfileEntity user = new UserProfileEntity(email, password, login, isBlocked, firstName, lastName);
        user.setRolesId(rolesId);
        userProfileService.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody List<UserProfileEntity> getAll() {
        return userProfileService.findAll();
    }

    @GetMapping(value = "/login/{login}")
    public ResponseEntity<UserProfileEntity> getUserByLogin(@PathVariable(name = "login") String login) {
        UserProfileEntity user = userProfileService.findByLogin(login);
        return ResponseEntity.ok(user);
    }
}
