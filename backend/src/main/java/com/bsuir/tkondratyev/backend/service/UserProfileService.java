package com.bsuir.tkondratyev.backend.service;

import com.bsuir.tkondratyev.backend.entity.RoleEntity;
import com.bsuir.tkondratyev.backend.entity.UserProfileEntity;

import java.util.List;
import java.util.Optional;

public interface UserProfileService {

    List<UserProfileEntity> findAll();
    Optional<UserProfileEntity> findByEmail(String email);
    UserProfileEntity save(UserProfileEntity user);
    void delete(Long id);
    Optional<UserProfileEntity> findById(long id);
    List<UserProfileEntity> findByRole(RoleEntity role);
}

