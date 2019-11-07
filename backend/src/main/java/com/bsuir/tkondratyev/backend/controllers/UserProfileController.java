package com.bsuir.tkondratyev.backend.controllers;

import com.bsuir.tkondratyev.backend.entity.RoleEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;
import com.bsuir.tkondratyev.backend.service.RolesService;
import com.bsuir.tkondratyev.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RolesService rolesService;

    @PostMapping(path = "/signup")
    public UserProfileEntity saveUser(@RequestBody UserProfileEntity userProfileEntity) {
        return userProfileService.save(userProfileEntity);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<UserProfileEntity> getUserById(@PathVariable(name = "id") Long id) {
        Optional<UserProfileEntity> user = userProfileService.findById(id);
        return user.map(ResponseEntity::ok).orElse(null);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<UserProfileEntity> getAll() {
        return userProfileService.findAll();
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<UserProfileEntity> getUserByEmail(@PathVariable(name = "email") String email) {
        Optional<UserProfileEntity> user = userProfileService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElse(null);
    }

    @GetMapping(path = "/role/{id}")
    public List<UserProfileEntity> getByRole(@PathVariable(name = "id") Long id) {
        Optional<RoleEntity> role = rolesService.findById(id);
        return role.map(roleEntity -> userProfileService.findByRole(roleEntity)).orElse(null);
    }

    @PutMapping(value = "/block/id/{id}")
    public UserProfileEntity blockUser(@PathVariable Long id) {
        Optional<UserProfileEntity> user = userProfileService.findById(id);
        UserProfileEntity entity = user.get();
        entity.setIsBlocked((byte) 1);
        return userProfileService.save(entity);
    }

    @PutMapping(value = "/activate/id/{id}")
    public UserProfileEntity activateUser(@PathVariable Long id) {
        Optional<UserProfileEntity> user = userProfileService.findById(id);
        UserProfileEntity entity = user.get();
        entity.setIsBlocked((byte) 0);
        return userProfileService.save(entity);
    }
}
