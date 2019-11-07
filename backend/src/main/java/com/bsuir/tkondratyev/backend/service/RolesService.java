package com.bsuir.tkondratyev.backend.service;

import com.bsuir.tkondratyev.backend.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    List<RoleEntity> findAll();
    RoleEntity findByName(String name);
    Optional<RoleEntity> findById(Long id);
    RoleEntity save(RoleEntity roles);
    void delete(Long id);
}
