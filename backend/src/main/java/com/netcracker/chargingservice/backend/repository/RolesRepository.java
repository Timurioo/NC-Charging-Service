package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);
}
