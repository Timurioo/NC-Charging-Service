package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
    Optional<RoleEntity> findById(Long id);
}
