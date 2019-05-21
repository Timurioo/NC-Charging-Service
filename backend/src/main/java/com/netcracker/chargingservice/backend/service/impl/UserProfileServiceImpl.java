package com.netcracker.chargingservice.backend.service.impl;

import com.netcracker.chargingservice.backend.entity.RoleEntity;
import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.repository.UserProfileRepository;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfileEntity> findAll() {
        return (List<UserProfileEntity>) userProfileRepository.findAll();
    }

    @Override
    public Optional<UserProfileEntity> findByEmail(String email) {
        return userProfileRepository.findByEmail(email);
    }

    @Override
    public Optional<UserProfileEntity> findById(long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public UserProfileEntity save(UserProfileEntity user) {
        boolean userForComparison = userProfileRepository.findByEmail(user.getEmail()).isPresent();
        if (user.getId() != null || !userForComparison) {
            return userProfileRepository.save(user);
        } else return null;
    }

    @Override
    public void delete(Long id) {
        userProfileRepository.deleteById(id);
    }

    @Override
    public List<UserProfileEntity> findByRole(RoleEntity role) { return userProfileRepository.findByRole(role); }
}
