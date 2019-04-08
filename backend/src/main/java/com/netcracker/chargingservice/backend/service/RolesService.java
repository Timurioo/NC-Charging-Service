package com.netcracker.chargingservice.backend.service;

import com.netcracker.chargingservice.backend.entity.RolesEntity;

import java.util.List;

public interface RolesService {
    List<RolesEntity> findAll();
    RolesEntity findByName(String name);
    RolesEntity save(RolesEntity roles);
    void delete(Integer id);
}
