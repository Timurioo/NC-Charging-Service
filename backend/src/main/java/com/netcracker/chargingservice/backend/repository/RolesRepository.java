package com.netcracker.chargingservice.backend.repository;

import com.netcracker.chargingservice.backend.entity.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {
    RolesEntity findByName(String name);
}
