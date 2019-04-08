package com.netcracker.chargingservice.backend.service.impl;

import com.netcracker.chargingservice.backend.entity.UserProfileEntity;
import com.netcracker.chargingservice.backend.repository.UserProfileRepository;
import com.netcracker.chargingservice.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public List<UserProfileEntity> findAll() {
        return (List<UserProfileEntity>) userProfileRepository.findAll();
    }

    @Override
    public UserProfileEntity findByLogin(String login) {
        return userProfileRepository.findByLogin(login);
    }

    @Override
    public UserProfileEntity save(UserProfileEntity user) {
        return userProfileRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userProfileRepository.deleteById(id);
    }
}
