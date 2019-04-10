package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.RoleEntity;

import java.util.List;

public interface RolesService {
    List<RoleEntity> findAll();
    RoleEntity findByName(String name);
    RoleEntity save(RoleEntity roles);
    void delete(Integer id);
}
